package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;
import com.coffee.coffeecraft.level.tile.TileSand;

public class ItemSand extends Item {
    public ItemSand(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (level.getTile(x, y) != Tile.DIRT.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(2)) {
            return false;
        }

        mob.removeItem(this, 1);
        level.setTile(x, y, Tile.SAND.id);
        return true;
    }

    @Override
    public String getName() {
        return "SAND";
    }

    @Override
    public int getColor() {
        return TileSand.COLOR;
    }

    @Override
    public int getIconX() {
        return 6;
    }

    @Override
    public int getIconY() {
        return 0;
    }
}
