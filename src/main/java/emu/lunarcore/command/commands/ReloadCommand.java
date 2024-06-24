package emu.lunarcore.command.commands;

import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "reload", permission = "admin.reload", desc = "/reload. Reloads the server config.")
public class ReloadCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        LunarCore.loadConfig();
        LunarCore.loadHotfixData();
        args.sendMessage("重载服务端配置");
    }

}
