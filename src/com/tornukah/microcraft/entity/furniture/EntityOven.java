package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.crafting.OvenMenu;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.level.Level;

public class EntityOven extends EntityFurniture {
    public EntityOven(Level level) {
        super(level, Item.OVEN, 15, 13);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new OvenMenu((EntityPlayer) e, this));
        return true;
    }
}
