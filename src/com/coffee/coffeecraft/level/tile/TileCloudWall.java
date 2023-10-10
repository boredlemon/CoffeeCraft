package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.tool.ItemTool;

public class TileCloudWall extends TileRock {
    public TileCloudWall(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_NONE;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_NONE;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }

    @Override
    public int getColor() {
        return Color.get(333, 444, 555, 555);
    }
}
