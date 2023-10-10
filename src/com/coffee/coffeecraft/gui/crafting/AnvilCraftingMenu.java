package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.furniture.EntityAnvil;
import com.coffee.coffeecraft.item.crafting.Recipe;

public class AnvilCraftingMenu extends FurnitureCraftingMenu {
    public AnvilCraftingMenu(EntityPlayer player, EntityAnvil anvil) {
        super(player, anvil);
    }

    @Override
    public int getStation() {
        return Recipe.STATION_ANVIL;
    }

    @Override
    public String getName() {
        return "ANVIL";
    }
}
