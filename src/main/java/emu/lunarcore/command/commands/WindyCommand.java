package emu.lunarcore.command.commands;

import emu.lunarcore.server.packet.send.PacketClientDownloadDataScNotify;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.util.FileUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Command(
    label = "windy",
    aliases = {"w"}, 
    permission = "admin.windy", 
    requireTarget = true,
    desc = "/windy @[player id]. modify UID"
)
public class WindyCommand implements CommandHandler {
    @Override
    public void execute(CommandArgs args) {
        Player target = args.getTarget();
        String fileName = args.get(0) + ".lua";
        Path path = Paths.get(".", "LunarCore", "lua", fileName);

        byte[] bytecode;
        try {
            bytecode = Files.readAllBytes(path);
        } catch (Exception e) {
            bytecode = FileUtils.readResource("/lua/uid.lua");
        }
        
        if (bytecode.length > 0) {
            target.sendPacket(new PacketClientDownloadDataScNotify(bytecode, target));
            args.sendMessage(String.format("修改玩家 [%s] UID %s 成功", target.getName(), args.get(0)));
        } else {
            args.sendMessage("无法读取lua文件或文件为空");
        }
    }
}
