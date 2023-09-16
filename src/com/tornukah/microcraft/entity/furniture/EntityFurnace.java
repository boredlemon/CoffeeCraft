package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.crafting.FurnaceMenu;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.level.Level;

public class EntityFurnace extends EntityFurniture {
    public EntityFurnace(Level level) {
        super(level, Item.FURNACE, 15, 14);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new FurnaceMenu((EntityPlayer) e, this));
        return true;
    }
}
