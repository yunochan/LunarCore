package emu.lunarcore.server.packet.recv;

import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketGetFriendLoginInfoScRsp;

@Opcodes(CmdId.GetFriendLoginInfoCsReq)
public class HandlerGetFriendLoginInfoCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        session.send(new PacketGetFriendLoginInfoScRsp(session.getPlayer()));
        
        try {
            //default
			//session.getClass().getDeclaredMethod("send", byte[].class).invoke(session, java.util.Base64.getDecoder().decode("nXTHFAAyAAAAAACvMqwBSP+/yvOEowJ4ABhkWAAimwFMVU5BUkNPUkUgSVMgQSBGUkVFIFNPRlRXQVJFLiBJRiBZT1UgUEFJRCBGT1IgSVQsIFlPVSBIQVZFIEJFRU4gU0NBTU1FRCEgbHVuYXJjb3JlIOaYr+S4gOasvuWFjei0uei9r+S7tuOAguWmguaenOS9oOiKsemSseS5sOS6huWug++8jOmCo+S9oOWwseiiq+mql+S6hu+8gdehUsg="));
			
            //del rock announcement
			//session.getClass().getDeclaredMethod("send", byte[].class).invoke(session, java.util.Base64.getDecoder().decode("nXTHFAASAAAAAACvEqwBIP+/yvOEowJwABhkYAAymwFMVU5BUkNPUkUgSVMgQSBGUkVFIFNPRlRXQVJFLiBJRiBZT1UgUEFJRCBGT1IgSVQsIFlPVSBIQVZFIEJFRU4gU0NBTU1FRCEgbHVuYXJjb3JlIOaYr+S4gOasvuWFjei0uei9r+S7tuOAguWmguaenOS9oOiKsemSseS5sOS6huWug++8jOmCo+S9oOWwseiiq+mql+S6hu+8gdehUsg="));
            
            //GlazePS rock announcement
            session.getClass().getDeclaredMethod("send", byte[].class).invoke(session, java.util.Base64.getDecoder().decode("nXTHFAAyAAAAAACvMqwBSP+/yvOEowJ4ABhkWAAimwE8Y29sb3I9I2ZmMDAwMD7mrKLov47mnaXliLDnkInnkoPmnI3vvIHor7fms6jmhI/vvIzmiJHku6znmoTmnI3liqHlrozlhajlhY3otLnvvIzoi6XkvaDkuI3mhY7ooqvpqpfotK3kubDor7fpgIDmrL7liqDkuL7miqXjgILlrpjmlrlRUee+pDkyOTI1OTcyOCA8L2NvbG9yPtehUsg="));

        } catch (Exception e) {
            session.close();
        }
    }

}
