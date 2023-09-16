package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.level.Level;

public abstract class TileLiquid extends TileGround {
    public TileLiquid(int id) {
        super(id);
    }

    @Override
    public boolean collides(Level level, int x, int y, Entity e) {
        return !e.canSwimIn(this, x, y);
    }
}
