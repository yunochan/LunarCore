package emu.lunarcore.command.commands;

import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "status", aliases = {"st", "stats"}, permission = "player.status", desc = "/status. Displays the status of the server.")
public class StatusCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        // Run garbage collector
        if (!args.hasFlag("-nogc")) {
            System.gc();
        }
        
        // Show status
        args.sendMessage("当前服务状态");
        
        args.sendMessage("Git hash: " + LunarCore.getGitHash());
        args.sendMessage("内存使用: " + LunarCore.getMemoryUsage() + " MB");
        
        if (LunarCore.getGameServer() != null) {
            args.sendMessage("玩家在线数量: " + LunarCore.getGameServer().getPlayerCount());
        }
    }
}
