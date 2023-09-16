package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;

public class TilePoppy extends TileFlower {

    public TilePoppy(int id) {
        super(id);
    }

    @Override
    public Item getDrop() {
        return Item.POPPY;
    }

    @Override
    public int getFlowerColor() {
        return Color.get(222, 422, 441, 553);
    }
}
