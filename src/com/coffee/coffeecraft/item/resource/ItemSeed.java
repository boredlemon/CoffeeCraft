package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;

public class ItemSeed extends Item {
    public ItemSeed(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (level.getTile(x, y) != Tile.FARMLAND.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(2)) {
            return false;
        }

        mob.removeItem(this, 1);
        level.setTile(x, y, Tile.WHEAT.id);
        return true;
    }

    @Override
    public String getName() {
        return "SEED";
    }

    @Override
    public int getColor() {
        return Color.get(252, 252, 353, 454);
    }

    @Override
    public int getIconX() {
        return 2;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
