package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;
import com.coffee.coffeecraft.level.tile.TileFlower;

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
