package emu.lunarcore.game.avatar;

import java.util.Iterator;
import java.util.stream.Stream;

import emu.lunarcore.LunarRail;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.AvatarExcel;
import emu.lunarcore.game.player.BasePlayerManager;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.server.packet.send.PacketPlayerSyncScNotify;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class AvatarStorage extends BasePlayerManager implements Iterable<GameAvatar> {
    private final Int2ObjectMap<GameAvatar> avatars;

    public AvatarStorage(Player player) {
        super(player);
        this.avatars = new Int2ObjectOpenHashMap<>();
    }

    public Int2ObjectMap<GameAvatar> getAvatars() {
        return avatars;
    }

    public int getAvatarCount() {
        return this.avatars.size();
    }

    public GameAvatar getAvatarById(int id) {
        return getAvatars().get(id);
    }

    public boolean hasAvatar(int id) {
        return getAvatars().containsKey(id);
    }

    public boolean addAvatar(GameAvatar avatar) {
        // Sanity
        if (avatar.getExcel() == null || this.hasAvatar(avatar.getAvatarId())) {
            return false;
        }

        // Set owner first
        avatar.setOwner(getPlayer());

        // Put into maps
        this.avatars.put(avatar.getAvatarId(), avatar);

        // Save to database
        avatar.save();

        // Send packet
        getPlayer().sendPacket(new PacketPlayerSyncScNotify(avatar));

        return true;
    }

    public void recalcAvatarStats() {
        //this.getAvatars().values().stream().forEach(GameAvatar::recalcStats);
    }

    @Override
    public Iterator<GameAvatar> iterator() {
        return getAvatars().values().iterator();
    }

    // Database

    public void loadFromDatabase() {
        Stream<GameAvatar> stream = LunarRail.getGameDatabase().getObjects(GameAvatar.class, "ownerUid", this.getPlayer().getUid());

        stream.forEach(avatar -> {
            // Should never happen
            if (avatar.getId() == null) {
                return;
            }

            // Load avatar excel data
            AvatarExcel excel = GameData.getAvatarExcelMap().get(avatar.getAvatarId());
            if (excel == null) {
                return;
            }

            // Set ownerships
            avatar.setExcel(excel);
            avatar.setOwner(getPlayer());

            // Add to avatar storage
            this.avatars.put(avatar.getAvatarId(), avatar);
        });
    }
}