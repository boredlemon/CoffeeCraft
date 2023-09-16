package com.tornukah.microcraft.item.resource;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;
import com.tornukah.microcraft.level.tile.TileCactus;

public class ItemCactus extends Item {
    public ItemCactus(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (level.getTile(x, y) != Tile.SAND.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(1)) {
            return false;
        }

        mob.removeItem(this, 1);
        level.setTile(x, y, Tile.CACTUS.id);
        return true;
    }

    @Override
    public String getName() {
        return "CACTUS";
    }

    @Override
    public int getColor() {
        return TileCactus.COLOR;
    }

    @Override
    public int getIconX() {
        return 8;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
