package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.util.Position;
import emu.lunarcore.util.Utils;

@Command(
    label = "position",
    aliases = {"pos"}, 
    permission = "admin.position", 
    requireTarget = true,
    desc = "/position @[player id]. Get the target player's current position information "
    
)
public class PositionCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        Player target = args.getTarget();
        if (target != null) {
        Position pos = target.getPos();
        Position rot = target.getRot();
        args.sendMessage(String.format("Position - x: %d, y: %d, z: %d", pos.getX(), pos.getY(), pos.getZ()));
        args.sendMessage(String.format("Rotation - x: %d, y: %d, z: %d", rot.getX(), rot.getY(), rot.getZ()));
        args.sendMessage(String.format("sceneId: %d, floorId: %d, entryId:%d", target.getPlaneId(), target.getFloorId(), target.getEntryId()));
        } else {
        args.sendMessage("玩家不在游戏内");
        }
    }
}
