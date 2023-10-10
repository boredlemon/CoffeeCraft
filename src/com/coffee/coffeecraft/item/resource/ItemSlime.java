package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;

public class ItemSlime extends Item {
    public ItemSlime(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "SLIME";
    }

    @Override
    public int getColor() {
        return Color.get(111, 121, 141, 252);
    }

    @Override
    public int getIconX() {
        return 5;
    }

    @Override
    public int getIconY() {
        return 6;
    }
}
