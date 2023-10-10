package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.furniture.EntityCraftingBench;
import com.coffee.coffeecraft.item.crafting.Recipe;

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
