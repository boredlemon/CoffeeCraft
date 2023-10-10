package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;
import com.coffee.coffeecraft.level.tile.TileCactus;

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
