package emu.lunarcore.game.inventory;

import java.util.Collection;
import java.util.stream.Stream;

import emu.lunarcore.LunarRail;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.common.ItemParam;
import emu.lunarcore.data.common.ItemParam.ItemParamType;
import emu.lunarcore.data.excel.AvatarExcel;
import emu.lunarcore.data.excel.ItemExcel;
import emu.lunarcore.game.avatar.AvatarStorage;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.player.BasePlayerManager;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.server.packet.send.PacketPlayerSyncScNotify;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

public class Inventory extends BasePlayerManager {
    private final Long2ObjectMap<GameItem> store;
    private final Int2ObjectMap<InventoryTab> inventoryTypes;
    private int nextInternalUid;

    public Inventory(Player player) {
        super(player);

        this.store = new Long2ObjectOpenHashMap<>();
        this.inventoryTypes = new Int2ObjectOpenHashMap<>();

        this.createInventoryTab(ItemMainType.Equipment, new EquipInventoryTab(1500));
        this.createInventoryTab(ItemMainType.Relic, new EquipInventoryTab(1500));
        this.createInventoryTab(ItemMainType.Material, new MaterialInventoryTab(2000));
    }

    public AvatarStorage getAvatarStorage() {
        return this.getPlayer().getAvatars();
    }

    public Long2ObjectMap<GameItem> getItems() {
        return store;
    }

    public Int2ObjectMap<InventoryTab> getInventoryTypes() {
        return inventoryTypes;
    }

    public InventoryTab getInventoryTab(ItemMainType type) {
        return getInventoryTypes().get(type.getVal());
    }

    public void createInventoryTab(ItemMainType type, InventoryTab tab) {
        this.getInventoryTypes().put(type.getVal(), tab);
    }

    public int getNextItemInternalUid() {
        return ++nextInternalUid;
    }

    /* Returns an item using its internal uid
     * */
    public GameItem getItemByUid(int uid) {
        return this.getItems().get(uid);
    }

    public GameItem getMaterialByItemId(int id) {
        return this.getInventoryTab(ItemMainType.Material).getItemById(id);
    }

    public GameItem getItemByParam(ItemParam param) {
        if (param.getType() == ItemParamType.PILE) {
            return this.getMaterialByItemId(param.getId());
        } else if (param.getType() == ItemParamType.UNIQUE) {
            return this.getItemByUid(param.getId());
        }

        return null;
    }

    public boolean addItem(int itemId) {
        return addItem(itemId, 1);
    }

    public boolean addItem(int itemId, int count) {
        ItemExcel excel = GameData.getItemExcelMap().get(itemId);

        if (excel == null) {
            return false;
        }

        GameItem item = new GameItem(excel, count);

        return addItem(item);
    }

    public boolean addItem(GameItem item) {
        GameItem result = putItem(item);

        if (result != null) {
            // TODO Send packet (update)
            getPlayer().sendPacket(new PacketPlayerSyncScNotify(item));
            return true;
        }

        return false;
    }

    private synchronized GameItem putItem(GameItem item) {
        // Dont add items that dont have a valid item definition.
        if (item.getExcel() == null) {
            return null;
        }

        // Add item to inventory store
        ItemMainType type = item.getExcel().getItemMainType();
        InventoryTab tab = getInventoryTab(type);

        // Add
        switch (type) {
        case Equipment:
        case Relic:
            if (tab.getSize() >= tab.getMaxCapacity()) {
                return null;
            }
            // Duplicates cause problems
            item.setCount(Math.max(item.getCount(), 1));
            // Adds to inventory
            this.putItem(item, tab);
            // Set ownership and save to database
            item.save();
            return item;
        case Virtual:
            // Handle
            this.addVirtualItem(item.getItemId(), item.getCount());
            return item;
        case AvatarCard:
            // Add avatar
            AvatarExcel avatarExcel = GameData.getAvatarExcelMap().get(item.getItemId());
            if (avatarExcel != null && !getPlayer().getAvatars().hasAvatar(avatarExcel.getId())) {
                getPlayer().addAvatar(new GameAvatar(avatarExcel));
            }
            return null;
        case Material:
            switch (item.getExcel().getItemSubType()) {
            default:
                if (tab == null) {
                    return null;
                }
                GameItem existingItem = tab.getItemById(item.getItemId());
                if (existingItem == null) {
                    // Item type didnt exist before, we will add it to main inventory map if there is enough space
                    if (tab.getSize() >= tab.getMaxCapacity()) {
                        return null;
                    }
                    this.putItem(item, tab);
                    // Set ownership and save to db
                    item.save();
                    return item;
                } else {
                    // Add count
                    existingItem.setCount(Math.min(existingItem.getCount() + item.getCount(), item.getExcel().getPileLimit()));
                    existingItem.save();
                    return existingItem;
                }
            }
        default:
            return null;
        }
    }

    private synchronized void putItem(GameItem item, InventoryTab tab) {
        // Set owner and internal uid first
        item.setOwner(this.getPlayer());

        // Add if tab exists
        if (tab != null) {
            // Put in item store
            getItems().put(item.getInternalUid(), item);
            // Add to tab
            tab.onAddItem(item);
        }
    }

    private void addVirtualItem(int itemId, int count) {
        switch (itemId) {
        case 1: // Stellar Jade
            getPlayer().addHCoin(count);
            break;
        case 2: // Credit
            getPlayer().addSCoin(count);
            break;
        case 3: // Oneiric Shard
            getPlayer().addMCoin(count);
            break;
        case 11: // Trailblaze Power
            getPlayer().addStamina(count);
            break;
        case 22: // Trailblaze EXP
            getPlayer().addExp(count);
            break;
        }
    }

    public synchronized void removeItems(Collection<ItemParam> items) {
        for (ItemParam param : items) {
            GameItem item = this.getItemByParam(param);

            if (item != null) {
                this.removeItem(item, param.getCount());
            }
        }
    }

    public synchronized boolean removePileItem(int uid, int count) {
        GameItem item = this.getMaterialByItemId(uid);

        if (item == null) {
            return false;
        }

        return removeItem(item, count);
    }

    public synchronized boolean removeUniqueItem(int uid, int count) {
        GameItem item = this.getItemByUid(uid);

        if (item == null) {
            return false;
        }

        return removeItem(item, count);
    }

    public synchronized boolean removeItem(GameItem item, int count) {
        // Sanity check
        if (count <= 0 || item == null || item.getOwnerUid() != getPlayer().getUid()) {
            return false;
        }

        if (item.getExcel() == null || item.getExcel().isEquippable()) {
            item.setCount(0);
        } else {
            item.setCount(item.getCount() - count);
        }

        if (item.getCount() <= 0) {
            // Remove from inventory tab too
            InventoryTab tab = null;
            if (item.getExcel() != null) {
                tab = getInventoryTab(item.getExcel().getItemMainType());
            }
            // Remove from inventory if less than 0
            deleteItem(item, tab);
            // TODO Send packet (delete)
            getPlayer().sendPacket(new PacketPlayerSyncScNotify(item));
        } else {
            // TODO Send packet (update)
            getPlayer().sendPacket(new PacketPlayerSyncScNotify(item));
        }

        // Update in db
        item.save();

        // Returns true on success
        return true;
    }

    private void deleteItem(GameItem item, InventoryTab tab) {
        getItems().remove(item.getInternalUid());
        if (tab != null) {
            tab.onRemoveItem(item);
        }
    }

    // Equips

    public boolean equipItem(int avatarId, int equipId) {
        GameAvatar avatar = getPlayer().getAvatarById(avatarId);
        GameItem item = this.getItemByUid(equipId);

        if (avatar != null && item != null) {
            return avatar.equipItem(item);
        }

        return false;
    }

    public boolean unequipItem(int avatarId, int slot) {
        GameAvatar avatar = getPlayer().getAvatars().getAvatarById(avatarId);

        if (avatar != null) {
            GameItem unequipped = avatar.unequipItem(slot);
            if (unequipped != null) {
                getPlayer().sendPacket(new PacketPlayerSyncScNotify(avatar, unequipped));
                return true;
            }
        }

        return false;
    }

    // Database

    public void loadFromDatabase() {
        Stream<GameItem> stream = LunarRail.getGameDatabase().getObjects(GameItem.class, "ownerUid", this.getPlayer().getUid());

        stream.forEach(item -> {
            // Should never happen
            if (item.getId() == null) {
                return;
            }

            // Load item excel data
            ItemExcel excel = GameData.getItemExcelMap().get(item.getItemId());
            if (excel == null) {
                // Delete item if it has no excel data
                item.setCount(0);
                item.save();
                return;
            }

            // Set ownerships
            item.setExcel(excel);

            // Put in inventory
            InventoryTab tab = getInventoryTab(item.getExcel().getItemMainType());
            putItem(item, tab);

            // Equip to a character if possible
            if (item.isEquipped()) {
                GameAvatar avatar = getPlayer().getAvatarById(item.getEquipAvatar());
                boolean hasEquipped = false;

                if (avatar != null) {
                    hasEquipped = avatar.equipItem(item);
                }

                if (!hasEquipped) {
                    // Unset equipped flag on item since we couldnt find an avatar to equip it to
                    item.setEquipAvatar(0);
                    item.save();
                }
            }
        });
    }
}