package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.scene.entity.EntityNpc;
import emu.lunarcore.proto.DialogueResultOuterClass.DialogueResult;
import emu.lunarcore.proto.RogueDialogueEventOuterClass.RogueDialogueEvent;
import emu.lunarcore.proto.RogueDialogueEventParamOuterClass.RogueDialogueEventParam;
import emu.lunarcore.proto.SelectRogueDialogueEventScRspOuterClass.SelectRogueDialogueEventScRsp;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketSelectRogueDialogueEventScRsp extends BasePacket {

    public PacketSelectRogueDialogueEventScRsp(int dialogueEventId, EntityNpc npc, int nextEventId) {
        //super(CmdId.SelectRogueDialogueEventScRsp);
        super(CmdId.NONE);
        
        var data = SelectRogueDialogueEventScRsp.newInstance()
                .setDialogueEventId(dialogueEventId);
        
        var instance = npc.getScene().getPlayer().getRogueInstance();
        
        var params = instance.curDialogueParams.get(npc.getRogueNpcId());
        if (params == null) {
            params = instance.setDialogueParams(npc.getRogueNpcId());
        }
        
        var event = RogueDialogueEvent.newInstance()
            .setNpcId(npc.getRogueNpcId())
            .setGameModeType(5)
            .addSelectEventId(dialogueEventId)
            //.setEventUniqueId(instance.getEventUniqueId())
            .addAllRogueDialogueEventParam(params.toArray(RogueDialogueEventParam[]::new));
        
        var l = DialogueResult.newInstance();
        for (var param : params) {
            l.addEventIds(param.getDialogueEventId());
        }
        if (nextEventId != 0) {
            l.addEventIds(nextEventId);
        }
        data.setDialogueResult(l);
        data.setEventData(event);
        
        this.setData(data);
    }
}
