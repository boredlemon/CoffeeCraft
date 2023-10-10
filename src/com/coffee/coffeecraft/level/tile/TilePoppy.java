package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;

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
