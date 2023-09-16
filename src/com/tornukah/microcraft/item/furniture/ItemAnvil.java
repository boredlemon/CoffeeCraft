package com.tornukah.microcraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.furniture.EntityAnvil;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.Level;

public class ItemAnvil extends ItemFurniture {
    public ItemAnvil(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_BENCH,
                new RecipeIngredient(Item.IRON_INGOT, 8)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityAnvil(level);
    }

    @Override
    public int getTileSpriteX() {
        return 11;
    }

    @Override
    public int getTileSpriteY() {
        return 0;
    }

    @Override
    public String getName() {
        return "ANVIL";
    }

    @Override
    public int getColor() {
        return Color.get(111,  222, 333, 444);
    }

    @Override
    public int getIconX() {
        return 3;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
