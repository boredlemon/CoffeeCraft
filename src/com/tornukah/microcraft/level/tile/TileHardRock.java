package com.tornukah.microcraft.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.level.Level;

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
