package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.avatar.AvatarMultiPath;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.GetMultiPathAvatarInfoScRspOuterClass.GetMultiPathAvatarInfoScRsp;
import emu.lunarcore.proto.GetMultiPathAvatarInfoScRspOuterClass.GetMultiPathAvatarInfoScRsp.CurAvatarPathEntry;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketGetMultiPathAvatarInfoScRsp extends BasePacket {

    public PacketGetMultiPathAvatarInfoScRsp(Player player) {
        super(CmdId.GetMultiPathAvatarInfoScRsp);

        var data = GetMultiPathAvatarInfoScRsp.newInstance();
        
        for (AvatarMultiPath path : player.getAvatars().getMultiPaths().values()) {
            data.addMultiPathAvatarInfoList(path.toProto());
        }
        
        for (var entry : player.getCurAvatarPaths().entrySet()) {
            var info = CurAvatarPathEntry.newInstance()
                    .setKey(entry.getKey())
                    .setValueValue(entry.getValue());
            
            data.addCurAvatarPath(info);
            data.addBasicTypeIdList(entry.getValue());
        }

        this.setData(data);
    }
}
