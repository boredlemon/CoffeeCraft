package com.tornukah.microcraft.item.tool;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.Material;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;

public class ItemHoe extends ItemTool {
    private final int station;

    public ItemHoe(int id, int station, Material material) {
        super(id, ItemTool.TYPE_HOE, material);
        this.station = station;
    }

    @Override
    public double getStaminaCostMultiplier() {
        return 2.0;
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                this.station,
                new RecipeIngredient(Item.WOOD, 3),
                new RecipeIngredient(this.material.getBase(), 2)
            )
        );
    }

    @Override
    public String getName() {
        return this.material.name + " HOE";
    }

    @Override
    public int getColor() {
        return material.toolColor;
    }

    @Override
    public int getIconX() {
        return 4;
    }

    @Override
    public int getIconY() {
        return 6;
    }
}
