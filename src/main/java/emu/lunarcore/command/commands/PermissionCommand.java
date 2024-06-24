package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "permission", aliases = {"perm"}, permission = "admin.permission", requireTarget = true, desc = "/permission {add | remove | clear} [permission]. Gives/removes a permission from the targeted player.")
public class PermissionCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        String type = args.get(0).toLowerCase();
        String permission = args.get(1).toLowerCase();
        
        switch (type) {
            case "add" -> {
                // Add permission
                if (!permission.isEmpty()) {
                    args.getTarget().getAccount().addPermission(permission);
                }
                // Send message
                args.sendMessage("授予玩家 [" + args.getTarget().getName() + "] " + permission + "权限");
            }
            case "remove" -> {
                // Remove permission
                if (!permission.isEmpty()) {
                    args.getTarget().getAccount().removePermission(permission);
                }
                // Send message
                args.sendMessage("移除玩家 [" + args.getTarget().getName() + "] " + permission + "权限");
            }
            case "clear" -> {
                // Clear permissions
                args.getTarget().getAccount().clearPermission();
                // Send message
                args.sendMessage("清空玩家 [" + args.getTarget().getName() + "] 全部权限");
            }
            default -> {
                args.sendMessage("Error: 无效参数");
            }
        }
    }

}
