package com.coffee.coffeecraft.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;

public class TileHardRock extends TileRock {
    public TileHardRock(int id) {
        super(id);
    }

    @Override
    public List<ItemStack> getDrops(Level level, int x, int y) {
        List<ItemStack> result = new ArrayList<>();

        for (int i = Global.random.nextInt(2); i >= 0; i--) {
            result.add(new ItemStack(new ItemInstance(Item.ROCK)));
        }

        for (int i = Global.random.nextInt(4); i >= 0; i--) {
            result.add(new ItemStack(new ItemInstance(Item.COAL)));
        }

        return result;
    }

    @Override
    public int getHealth() {
        return (int) (super.getHealth() * 1.5);
    }

    @Override
    public int getColor() {
        return Color.get(322, 221, 332, 443);
    }
}
