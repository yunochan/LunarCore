package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.DressAvatarCsReqOuterClass.DressAvatarCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;

@Opcodes(CmdId.DressAvatarCsReq)
public class HandlerDressAvatarCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = DressAvatarCsReq.parseFrom(data);

        session.getPlayer().getInventory().equipItem(req.getAvatarId(), req.getEquipmentUniqueId());
        session.send(CmdId.DressAvatarScRsp);
    }

}
