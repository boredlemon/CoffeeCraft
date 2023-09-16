package com.tornukah.microcraft.gui.crafting;

import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.entity.furniture.EntityOven;
import com.tornukah.microcraft.entity.particle.EntitySmokeParticle;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;

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
