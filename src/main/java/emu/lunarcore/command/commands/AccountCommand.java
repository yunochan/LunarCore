package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.game.account.AccountHelper;
import emu.lunarcore.util.Utils;

@Command(label = "account", permission = "admin.account", desc = "/account {create | delete} [username] (reserved player uid). Creates or deletes an account.")
public class AccountCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        if (args.size() < 2) {
            args.sendMessage("参数数量无效");
            return;
        }
        
        String command = args.get(0).toLowerCase();
        String username = args.get(1);

        switch (command) {
            case "create" -> {
                // Reserved player uid
                int reservedUid = 0;
                
                if (args.size() >= 3) {
                    reservedUid = Utils.parseSafeInt(args.get(2));
                }
    
                if (AccountHelper.createAccount(username, null, reservedUid) != null) {
                    args.sendMessage(String.format("账号 %s 创建成功", username));

                } else {
                    args.sendMessage(String.format("账号 %s 已经存在，无法再创建！", username));
                }
            }
            case "delete" -> {
                if (AccountHelper.deleteAccount(username)) {
                    args.sendMessage(String.format("账号 %s 被删除", username));
                } else {
                    args.sendMessage(String.format("账号 %s 不存在", username));
                }
            }
        }
    }

}
