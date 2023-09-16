package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.crafting.AnvilCraftingMenu;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.level.Level;

public class EntityAnvil extends EntityFurniture {
    public EntityAnvil(Level level) {
        super(level, Item.ANVIL, 15, 10);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new AnvilCraftingMenu((EntityPlayer) e, this));
        return true;
    }
}
