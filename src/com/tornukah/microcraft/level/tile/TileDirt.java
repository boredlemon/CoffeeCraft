package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.tool.ItemTool;
import com.tornukah.microcraft.level.Level;

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
