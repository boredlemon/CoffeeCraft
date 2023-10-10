package com.coffee.coffeecraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.furniture.EntityCraftingBench;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;
import com.coffee.coffeecraft.level.Level;

public class ItemCraftingBench extends ItemFurniture {
    public ItemCraftingBench(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_ALL_CRAFTING,
                new RecipeIngredient(Item.WOOD, 6)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityCraftingBench(level);
    }

    @Override
    public int getTileSpriteX() {
        return 9;
    }

    @Override
    public int getTileSpriteY() {
        return 0;
    }

    @Override
    public String getName() {
        return "CRFT BENCH";
    }

    @Override
    public int getColor() {
        return Color.get(110, 220, 330, 330);
    }

    @Override
    public int getIconX() {
        return 1;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
