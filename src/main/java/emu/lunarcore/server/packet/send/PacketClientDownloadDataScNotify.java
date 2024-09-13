package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.ClientDownloadDataScNotifyOuterClass;
import emu.lunarcore.proto.ClientDownloadDataOuterClass.ClientDownloadData;
import emu.lunarcore.proto.ClientDownloadDataScNotifyOuterClass.ClientDownloadDataScNotify;
import emu.lunarcore.server.packet.BasePacket;

public class PacketClientDownloadDataScNotify extends BasePacket {
    public PacketClientDownloadDataScNotify(byte[] data, Player player) {
        super(53);
        ClientDownloadDataScNotifyOuterClass.ClientDownloadDataScNotify proto = ClientDownloadDataScNotify.newInstance().setDownloadData(ClientDownloadData.newInstance().setData(data).setVersion(81).setTime(System.currentTimeMillis() / 1000L));
        this.setData(proto);
    }
}