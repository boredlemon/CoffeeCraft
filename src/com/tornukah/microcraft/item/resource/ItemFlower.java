package com.tornukah.microcraft.item.resource;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;
import com.tornukah.microcraft.level.tile.TileFlower;

public class ItemFlower extends Item {
    private final String name;
    private final TileFlower tile;

    public ItemFlower(int id, String name, TileFlower tile) {
        super(id);
        this.name = name;
        this.tile = tile;
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (level.getTile(x, y) != Tile.GRASS.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(1)) {
            return false;
        }

        mob.removeItem(this, 1);
        level.setTile(x, y, this.tile.id);
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getColor() {
        return tile.getFlowerColor();
    }

    @Override
    public int getIconX() {
        return 2;
    }

    @Override
    public int getIconY() {
        return 0;
    }
}
