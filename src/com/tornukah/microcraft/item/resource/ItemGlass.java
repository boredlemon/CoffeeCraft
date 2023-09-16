package com.tornukah.microcraft.item.resource;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;

public class ItemGlass extends Item {
    public ItemGlass(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 2),
                Recipe.STATION_FURNACE,
                new RecipeIngredient(Item.SAND, 2),
                new RecipeIngredient(Item.COAL, 1)
            )
        );
    }

    @Override
    public String getName() {
        return "GLASS";
    }

    @Override
    public int getColor() {
        return Color.get(222, 333, 444, 555);
    }

    @Override
    public int getIconX() {
        return 11;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
