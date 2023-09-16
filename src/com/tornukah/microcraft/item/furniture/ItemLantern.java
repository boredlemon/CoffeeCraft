package com.tornukah.microcraft.item.furniture;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.furniture.EntityLantern;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.Level;

public class ItemLantern extends ItemFurniture {
    public ItemLantern(int id) {
        super(id);
    }

    @Override
    public int getLightPower() {
        return EntityLantern.LIGHT_POWER;
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_BENCH,
                new RecipeIngredient(Item.IRON_INGOT, 1),
                new RecipeIngredient(Item.GLASS, 4),
                new RecipeIngredient(Item.SLIME, 8)
            )
        );
    }

    @Override
    public Entity createEntity(Level level) {
        return new EntityLantern(level);
    }

    @Override
    public int getTileSpriteX() {
        return 10;
    }

    @Override
    public int getTileSpriteY() {
        return 6;
    }

    @Override
    public String getName() {
        return "LANTERN";
    }

    @Override
    public int getColor() {
        return Color.get(111, 222, 333, 552);
    }

    @Override
    public int getIconX() {
        return 5;
    }

    @Override
    public int getIconY() {
        return 7;
    }
}
