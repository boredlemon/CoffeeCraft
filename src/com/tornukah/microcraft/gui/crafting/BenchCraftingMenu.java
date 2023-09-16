package com.tornukah.microcraft.gui.crafting;

import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.entity.furniture.EntityCraftingBench;
import com.tornukah.microcraft.item.crafting.Recipe;

public class BenchCraftingMenu extends FurnitureCraftingMenu {
    public BenchCraftingMenu(EntityPlayer player, EntityCraftingBench bench) {
        super(player, bench);
    }

    @Override
    public int getStation() {
        return Recipe.STATION_ALL_CRAFTING;
    }

    @Override
    public String getName() {
        return "CRAFTING";
    }
}
