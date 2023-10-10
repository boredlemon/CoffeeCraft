package com.coffee.coffeecraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.furniture.EntityFurnace;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;
import com.coffee.coffeecraft.level.Level;

public class ItemFurnace extends ItemFurniture {
    public ItemFurnace(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_BENCH,
                new RecipeIngredient(Item.ROCK, 20),
                new RecipeIngredient(Item.COAL, 8)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityFurnace(level);
    }

    @Override
    public int getTileSpriteX() {
        return 13;
    }

    @Override
    public int getTileSpriteY() {
        return 2;
    }

    @Override
    public String getName() {
        return "FURNACE";
    }

    @Override
    public int getColor() {
        return Color.get(111, 333, 444, 530);
    }

    @Override
    public int getIconX() {
        return 4;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
