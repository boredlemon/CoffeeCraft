package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.gfx.Color;

public class TileCloud extends TileGround {
    public TileCloud(int id) {
        super(id);
    }

    @Override
    public int getColor() {
        return Color.get(222, 333, 444, 555);
    }

    @Override
    public int getTransitionColor() {
        return Color.get(222, 333, 444, 555);
    }
}
