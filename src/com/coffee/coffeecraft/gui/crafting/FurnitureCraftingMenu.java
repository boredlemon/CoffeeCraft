package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.furniture.EntityFurniture;

public abstract class FurnitureCraftingMenu extends CraftingMenu {
    protected final EntityFurniture furniture;

    public FurnitureCraftingMenu(EntityPlayer player, EntityFurniture furniture) {
        super(player);
        this.furniture = furniture;
    }
}
