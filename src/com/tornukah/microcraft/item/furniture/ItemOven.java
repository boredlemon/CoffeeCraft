package com.tornukah.microcraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.furniture.EntityOven;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.Level;

public class ItemOven extends ItemFurniture {
    public ItemOven(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_BENCH,
                new RecipeIngredient(Item.ROCK, 12),
                new RecipeIngredient(Item.WOOD, 4)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityOven(level);
    }

    @Override
    public int getTileSpriteX() {
        return 7;
    }

    @Override
    public int getTileSpriteY() {
        return 0;
    }

    @Override
    public String getName() {
        return "OVEN";
    }

    @Override
    public int getColor() {
        return Color.get(111, 222, 333, 440);
    }

    @Override
    public int getIconX() {
        return 0;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
