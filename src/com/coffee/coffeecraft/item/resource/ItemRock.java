package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;
import com.coffee.coffeecraft.level.tile.TileRock;

public class ItemRock extends Item {
    public ItemRock(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        int t = level.getTile(x, y);
        if (t != Tile.GRASS.id && t != Tile.DIRT.id &&
            t != Tile.STONE.id && t != Tile.SAND.id) {
            return false;
        }

        if (!level.trySetTile(x, y, Tile.COBBLESTONE.id)) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(4)) {
            return false;
        }

        mob.removeItem(this, 1);
        return true;
    }

    @Override
    public String getName() {
        return "ROCK";
    }

    @Override
    public int getColor() {
        return TileRock.COLOR;
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
