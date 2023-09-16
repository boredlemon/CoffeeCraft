package com.tornukah.microcraft.gui.crafting;

import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.entity.furniture.EntityFurniture;

public abstract class FurnitureCraftingMenu extends CraftingMenu {
    protected final EntityFurniture furniture;

    public FurnitureCraftingMenu(EntityPlayer player, EntityFurniture furniture) {
        super(player);
        this.furniture = furniture;
    }
}
