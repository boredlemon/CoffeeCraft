package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.level.Level;

public class TileSky extends TileLiquid {
    public TileSky(int id) {
        super(id);
    }

    @Override
    public void render(Level level, int x, int y) {
        Renderer.fill(
            Level.toPixel(x), Level.toPixel(y),
            16, 16, 335
        );
    }

    @Override
    public int getColor() {
        return 0;
    }

    @Override
    public int getTransitionColor() {
        return 0;
    }
}
