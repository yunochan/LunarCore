package emu.lunarcore.server.packet.recv;

import emu.lunarcore.LunarCore;
import emu.lunarcore.proto.SetClientPausedCsReqOuterClass.SetClientPausedCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketSetClientPausedScRsp;
import emu.lunarcore.server.packet.send.PacketClientDownloadDataScNotify;
import emu.lunarcore.util.FileUtils;

@Opcodes(CmdId.SetClientPausedCsReq)
public class HandlerSetClientPausedCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = SetClientPausedCsReq.parseFrom(data);
        
        session.getPlayer().setPaused(req.getPaused());
        session.send(new PacketSetClientPausedScRsp(session.getPlayer()));
         
        byte[] bytecode = FileUtils.readResource("/lua/uid.lua");
        if (bytecode.length > 0) {
            session.send(new PacketClientDownloadDataScNotify(bytecode, session.getPlayer()));
             LunarCore.getLogger().info("lua文件加载成功");
        } else {
            LunarCore.getLogger().warn("找不到lua文件或文件为空");
        }
    }
}
