package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.crafting.BenchCraftingMenu;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.level.Level;

public class EntityCraftingBench extends EntityFurniture {
    public EntityCraftingBench(Level level) {
        super(level, Item.CRAFTING_BENCH, 15, 12);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new BenchCraftingMenu((EntityPlayer) e, this));
        return true;
    }
}
