package com.coffee.coffeecraft.item.armor;

import java.util.Collection;
import java.util.List;

import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.Material;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.item.crafting.RecipeIngredient;

public class ItemLeggings extends ItemArmor {
    public ItemLeggings(int id, int type, Material material) {
        super(id, 2, type, material);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(new ItemInstance(this, 0), 1),
                Recipe.STATION_ANVIL,
                new RecipeIngredient(this.material.getBase(), 6)
            )
        );
    }

    @Override
    public int getSpriteBaseX() {
        return 0;
    }

    @Override
    public int getSpriteBaseY() {
        return 24;
    }

    @Override
    public String getName() {
        return this.material.name + " LEGS";
    }

    @Override
    public int getColor() {
        return this.material.armorColor;
    }

    @Override
    public int getIconX() {
        return 8;
    }

    @Override
    public int getIconY() {
        return 6;
    }
}
