package com.coffee.coffeecraft.item.consumable;

import com.coffee.coffeecraft.gfx.Color;

public class ItemApple extends ItemFood {
    public ItemApple(int id) {
        super(id);
    }

    @Override
    public int getFoodValue() {
        return 2;
    }

    @Override
    public String getName() {
        return "APPLE";
    }

    @Override
    public int getColor() {
        return Color.get(100, 300, 422, 533);
    }

    @Override
    public int getIconX() {
        return 7;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
