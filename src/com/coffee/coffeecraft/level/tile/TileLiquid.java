package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.level.Level;

public abstract class TileLiquid extends TileGround {
    public TileLiquid(int id) {
        super(id);
    }

    @Override
    public boolean collides(Level level, int x, int y, Entity e) {
        return !e.canSwimIn(this, x, y);
    }
}
