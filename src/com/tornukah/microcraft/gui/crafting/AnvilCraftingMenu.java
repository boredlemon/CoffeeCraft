package com.tornukah.microcraft.gui.crafting;

import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.entity.furniture.EntityAnvil;
import com.tornukah.microcraft.item.crafting.Recipe;

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
