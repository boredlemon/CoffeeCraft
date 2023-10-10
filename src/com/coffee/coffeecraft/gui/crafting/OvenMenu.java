package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.furniture.EntityOven;
import com.coffee.coffeecraft.entity.particle.EntitySmokeParticle;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.crafting.Recipe;

public class OvenMenu extends FurnitureCraftingMenu {
    public OvenMenu(EntityPlayer player, EntityOven oven) {
        super(player, oven);
    }

    @Override
    protected void onCraft(ItemStack stack) {
        super.onCraft(stack);
        EntitySmokeParticle.spawn(
            this.furniture.level,
            this.furniture.getCenterX(), this.furniture.getCenterY(),
            Item.COAL.getColor(),
            2, 5
        );
    }

    @Override
    public int getStation() {
        return Recipe.STATION_OVEN;
    }

    @Override
    public String getName() {
        return "OVEN";
    }
}
