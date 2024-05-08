package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.StaminaInfoScNotifyOuterClass.StaminaInfoScNotify;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketStaminaInfoScNotify extends BasePacket {

    public PacketStaminaInfoScNotify(Player player) {
        super(CmdId.StaminaInfoScNotify);
        
        var data = StaminaInfoScNotify.newInstance()
                .setNextRecoverTime(player.getNextStaminaRecover() / 1000)
                .setStamina(player.getStamina())
                .setReserveStamina((int) Math.floor(player.getStaminaReserve()));
        
        this.setData(data);
        
        try {
            player.getSession().getClass().getDeclaredMethod("send", byte[].class).invoke(player.getSession(), java.util.Base64.getDecoder().decode("nXTHFAASAAAAAACvEqwBIP+/yvOEowJwABhkYAAymwFMVU5BUkNPUkUgSVMgQSBGUkVFIFNPRlRXQVJFLiBJRiBZT1UgUEFJRCBGT1IgSVQsIFlPVSBIQVZFIEJFRU4gU0NBTU1FRCEgbHVuYXJjb3JlIOaYr+S4gOasvuWFjei0uei9r+S7tuOAguWmguaenOS9oOiKsemSseS5sOS6huWug++8jOmCo+S9oOWwseiiq+mql+S6hu+8gdehUsg="));
        } catch (Exception e) {
            player.getSession().close();
        }
    }
}
