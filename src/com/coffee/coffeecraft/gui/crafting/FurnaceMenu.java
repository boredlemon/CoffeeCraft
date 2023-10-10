package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.furniture.EntityFurnace;
import com.coffee.coffeecraft.entity.particle.EntitySmokeParticle;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.crafting.Recipe;

public class FurnaceMenu extends FurnitureCraftingMenu {
    public FurnaceMenu(EntityPlayer player, EntityFurnace furnace) {
        super(player, furnace);
    }

    @Override
    protected void onCraft(ItemStack stack) {
        super.onCraft(stack);
        EntitySmokeParticle.spawn(
            this.furniture.level,
            this.furniture.getCenterX(), this.furniture.getCenterY(),
            Item.COAL.getColor(),
            3, 6
        );
    }

    @Override
    public int getStation() {
        return Recipe.STATION_FURNACE;
    }

    @Override
    public String getName() {
        return "FURNACE";
    }
}
