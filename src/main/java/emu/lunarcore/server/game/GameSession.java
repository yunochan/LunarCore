package emu.lunarcore.server.game;

import java.net.InetSocketAddress;

import emu.lunarcore.LunarRail;
import emu.lunarcore.game.account.Account;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdIdUtils;
import emu.lunarcore.server.packet.SessionState;
import emu.lunarcore.util.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import kcp.highway.Ukcp;
import lombok.Getter;

public class GameSession {
    @Getter private final GameServer server;
    @Getter private InetSocketAddress address;

    @Getter private Account account;
    @Getter private Player player;

    // Network
    private Ukcp ukcp;

    // Flags
    @Getter private SessionState state = SessionState.WAITING_FOR_TOKEN;
    private boolean useSecretKey;

    private GameSession(GameServer server) {
        this.server = server;
    }

    public GameSession(GameServer server, Ukcp ukcp) {
        this(server);
        this.ukcp = ukcp;
        this.address = this.ukcp.user().getRemoteAddress();
    }

    public int getUid() {
        return this.player.getUid();
    }

    public boolean useSecretKey() {
        return useSecretKey;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.player.setSession(this);
        this.getServer().registerPlayer(player);
    }

    public void setUseSecretKey(boolean key) {
        this.useSecretKey = key;
    }

    public void setState(SessionState state) {
        this.state = state;
    }

    public void onConnect() {
        LunarRail.getLogger().info("Client connected from " + address.getHostString());
    }

    public void onDisconnect() {
        LunarRail.getLogger().info("Client disconnected from " + address.getHostString());

        this.state = SessionState.INACTIVE;

        if (player != null) {
            // Save first
            player.save();
            // Deregister
            this.getServer().deregisterPlayer(player.getUid());
        }
    }

    public void onMessage(ByteBuf packet) {
        try {
            // Decrypt and turn back into a packet
            // Crypto.xor(packet.array(), useSecretKey() ? Crypto.ENCRYPT_KEY : Crypto.DISPATCH_KEY);

            // Decode
            while (packet.readableBytes() > 0) {
                // Length
                if (packet.readableBytes() < 16) {
                    return;
                }

                // Packet header sanity check
                int constHeader = packet.readInt();
                if (constHeader != BasePacket.HEADER_CONST) {
                    return; // Bad packet
                }

                // Data
                int opcode = packet.readShort();
                int headerLength = packet.readShort();
                int dataLength = packet.readInt();
                byte[] header = new byte[headerLength];
                byte[] data = new byte[dataLength];

                packet.readBytes(header);
                packet.readBytes(data);

                // Packet tail sanity check
                int constTail = packet.readInt();
                if (constTail != BasePacket.TAIL_CONST) {
                    return; // Bad packet
                }

                // Log packet
                if (LunarRail.getConfig().logPackets) {
                    logPacket("RECV", opcode, data);
                }

                // Handle
                getServer().getPacketHandler().handle(this, opcode, header, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // packet.release();
        }
    }

    public void send(BasePacket packet) {
        // Test
        if (packet.getOpcode() <= 0) {
            LunarRail.getLogger().warn("Tried to send packet with missing cmd id!");
            return;
        }

        // Send
        this.send(packet.build());

        // Log
        if (LunarRail.getConfig().logPackets) {
            logPacket("SEND", packet.getOpcode(), packet.getData());
        }
    }

    /**
     * Sends a empty packet with the specified cmd id.
     * @param cmdId
     */
    public void send(int cmdId) {
        // TODO optimize to send bytes with cmdId instead of creating a new base packet object
        this.send(new BasePacket(cmdId));
    }

    private void send(byte[] bytes) {
        if (this.ukcp != null) {
            ByteBuf buf = Unpooled.wrappedBuffer(bytes);
            this.ukcp.write(buf);
            buf.release();
        }
    }

    public void logPacket(String sendOrRecv, int opcode, byte[] payload) {
        LunarRail.getLogger().info(sendOrRecv + ": " + CmdIdUtils.getOpcodeName(opcode) + " (" + opcode + ")");
        System.out.println(Utils.bytesToHex(payload));
    }

    public void close() {
        this.ukcp.close();
    }
}