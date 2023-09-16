package com.tornukah.microcraft.item.consumable;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.tile.Tile;

public class ItemCactusGoo extends ItemFood {
    public ItemCactusGoo(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(this),
                Recipe.STATION_ALL_CRAFTING,
                new RecipeIngredient(Item.CACTUS)
            )
        );
    }

    @Override
    public int getFoodValue() {
        return 1;
    }

    @Override
    public String getName() {
        return "GOO";
    }

    @Override
    public int getColor() {
        return Tile.CACTUS.getColor();
    }

    @Override
    public int getIconX() {
        return 6;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
