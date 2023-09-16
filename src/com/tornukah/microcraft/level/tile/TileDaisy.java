package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;

public class TileDaisy extends TileFlower {

    public TileDaisy(int id) {
        super(id);
    }

    @Override
    public Item getDrop() {
        return Item.DAISY;
    }

    @Override
    public int getFlowerColor() {
        return Color.get(222, 444, 442, 553);
    }
}
