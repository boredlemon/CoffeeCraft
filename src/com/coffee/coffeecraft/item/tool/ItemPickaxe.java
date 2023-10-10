package com.coffee.coffeecraft.item.tool;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.Material;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;

public class ItemPickaxe extends ItemTool {
    private final int station;

    public ItemPickaxe(int id, int station, Material material) {
        super(id, ItemTool.TYPE_PICKAXE, material);
        this.station = station;
    }

    @Override
    public double getStaminaCostMultiplier() {
        return 2.4;
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                this.station,
                new RecipeIngredient(Item.WOOD, 3),
                new RecipeIngredient(this.material.getBase(), 4)
            )
        );
    }

    @Override
    public String getName() {
        return this.material.name + " PICK";
    }

    @Override
    public int getColor() {
        return material.toolColor;
    }

    @Override
    public int getIconX() {
        return 1;
    }

    @Override
    public int getIconY() {
        return 6;
    }
}
