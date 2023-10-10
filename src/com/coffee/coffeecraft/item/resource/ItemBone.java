package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;

public class ItemBone extends Item {
    public ItemBone(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "BONE";
    }

    @Override
    public int getColor() {
        return Color.get(221, 332, 442, 553);
    }

    @Override
    public int getIconX() {
        return 7;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
