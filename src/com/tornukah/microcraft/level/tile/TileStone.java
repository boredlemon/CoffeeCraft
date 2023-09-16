package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.gfx.Color;

public class TileStone extends TileGround {
    public static final int COLOR = Color.withComponent(
        Color.addAll(TileRock.COLOR, -111),
        Color.component(TileRock.COLOR, 0),
        0
    );

    public TileStone(int id) {
        super(id);
    }

    @Override
    public int getColor() {
        return COLOR;
    }

    @Override
    public int getTransitionColor() {
        return COLOR;
    }
}
