package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;

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
