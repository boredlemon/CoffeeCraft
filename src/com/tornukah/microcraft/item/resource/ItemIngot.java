package com.tornukah.microcraft.item.resource;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.Metal;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;

public class ItemIngot extends Item {
    public final Metal metal;

    public ItemIngot(int id, Metal metal) {
        super(id);
        this.metal = metal;
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_FURNACE,
                new RecipeIngredient(this.metal.getOre(), 2),
                new RecipeIngredient(Item.COAL, 1)
            )
        );
    }

    @Override
    public String getName() {
        return metal.name;
    }

    @Override
    public int getColor() {
        return metal.color;
    }

    @Override
    public int getIconX() {
        return 5;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
