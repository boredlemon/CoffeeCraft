package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.tool.ItemTool;
import com.coffee.coffeecraft.level.Level;

public class TileDirt extends TileGround {
    public static final int COLOR = Color.get(322, 221, 322, 211);

    public TileDirt(int id) {
        super(id);
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_HOE;
    }

    @Override
    public boolean hit(Level level, int x, int y, Entity e) {
        level.setTile(x, y, Tile.FARMLAND.id);
        return true;
    }

    @Override
    public int getColor() {
        return TileDirt.COLOR;
    }

    @Override
    public int getTransitionColor() {
        return TileDirt.COLOR;
    }
}
