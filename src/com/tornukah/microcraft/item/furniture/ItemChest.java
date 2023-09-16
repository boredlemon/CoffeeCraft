package com.tornukah.microcraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.furniture.EntityChest;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.Level;

public class ItemChest extends ItemFurniture {
    public ItemChest(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_BENCH,
                new RecipeIngredient(Item.WOOD, 10)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityChest(level);
    }

    @Override
    public int getTileSpriteX() {
        return 13;
    }

    @Override
    public int getTileSpriteY() {
        return 0;
    }

    @Override
    public String getName() {
        return "CHEST";
    }

    @Override
    public int getColor() {
        return Color.get(110, 221, 331, 441);
    }

    @Override
    public int getIconX() {
        return 2;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
