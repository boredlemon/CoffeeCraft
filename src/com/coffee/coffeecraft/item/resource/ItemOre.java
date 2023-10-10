package com.coffee.coffeecraft.item.resource;

import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.Metal;

public class ItemOre extends Item {
    public final Metal metal;

    public ItemOre(int id, Metal metal) {
        super(id);
        this.metal = metal;
    }

    @Override
    public String getName() {
        return metal.name + " ORE";
    }

    @Override
    public int getColor() {
        return metal.color;
    }

    @Override
    public int getIconX() {
        return 6;
    }

    @Override
    public int getIconY() {
        return 0;
    }
}
