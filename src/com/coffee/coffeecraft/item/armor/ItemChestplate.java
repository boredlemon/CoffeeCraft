package com.coffee.coffeecraft.item.armor;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.Material;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;

public class ItemChestplate extends ItemArmor {
    public ItemChestplate(int id, int type, Material material) {
        super(id, 1, type, material);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_ANVIL,
                new RecipeIngredient(this.material.getBase(), 8)
            )
        );
    }

    @Override
    public int getSpriteBaseX() {
        return 0;
    }

    @Override
    public int getSpriteBaseY() {
        return 20;
    }

    @Override
    public String getName() {
        return this.material.name + " CHEST";
    }

    @Override
    public int getColor() {
        return this.material.armorColor;
    }

    @Override
    public int getIconX() {
        return 7;
    }

    @Override
    public int getIconY() {
        return 6;
    }
}
