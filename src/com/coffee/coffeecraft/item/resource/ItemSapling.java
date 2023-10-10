package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;

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
