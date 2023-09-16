package com.tornukah.microcraft.item.resource;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;

public class ItemSapling extends Item {
    public ItemSapling(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        int t = level.getTile(x, y);
        if (t != Tile.GRASS.id && t != Tile.DIRT.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(2)) {
            return false;
        }

        mob.removeItem(this, 1);
        level.setTile(x, y, Tile.SAPLING.id);
        return true;
    }

    @Override
    public String getName() {
        return "ACORN";
    }

    @Override
    public int getColor() {
        return Color.get(110, 220, 320, 330);
    }

    @Override
    public int getIconX() {
        return 6;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
