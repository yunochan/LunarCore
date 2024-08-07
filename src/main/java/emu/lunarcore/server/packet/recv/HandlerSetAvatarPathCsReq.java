package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.SetAvatarPathCsReqOuterClass.SetAvatarPathCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketSetAvatarPathScRsp;

@Opcodes(CmdId.SetAvatarPathCsReq)
public class HandlerSetAvatarPathCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = SetAvatarPathCsReq.parseFrom(data);
        
        int pathId = session.getPlayer().setAvatarPath(req.getAvatarIdValue());
        session.send(new PacketSetAvatarPathScRsp(pathId));
    }

}
