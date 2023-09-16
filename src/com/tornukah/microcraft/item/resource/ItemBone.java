package com.tornukah.microcraft.item.resource;

import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;

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
