package com.coffee.coffeecraft.item.consumable;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;

public class ItemPie extends ItemFood {
    public ItemPie(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_OVEN,
                new RecipeIngredient(Item.APPLE, 1),
                new RecipeIngredient(Item.WHEAT, 4),
                new RecipeIngredient(Item.WOOD, 1)
            )
        );
    }

    @Override
    public int getFoodValue() {
        return 4;
    }

    @Override
    public String getName() {
        return "PIE";
    }

    @Override
    public int getColor() {
        return Color.get(111, 333, 551, 422);
    }

    @Override
    public int getIconX() {
        return 12;
    }

    @Override
    public int getIconY() {
        return 5;
    }
}
