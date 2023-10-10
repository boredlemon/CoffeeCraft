package com.coffee.coffeecraft.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;

public class TileBasalt extends TileRock {
    public TileBasalt(int id) {
        super(id);
    }

    @Override
    public List<ItemStack> getDrops(Level level, int x, int y) {
        List<ItemStack> result = new ArrayList<>();

        for (int i = Global.random.nextInt(3); i >= 0; i--) {
            result.add(new ItemStack(new ItemInstance(Item.COAL)));
        }

        return result;
    }

    @Override
    public int getHealth() {
        return (int) (super.getHealth() * 2.0);
    }

    @Override
    public int getColor() {
        return Color.get(322, 000, 111, 222);
    }
}
