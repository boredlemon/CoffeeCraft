package com.tornukah.microcraft.item.resource;

import java.util.Collection;
import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.entity.particle.EntitySmokeParticle;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.item.crafting.RecipeIngredient;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;

public class ItemBonemeal extends Item {
    public ItemBonemeal(int id) {
        super(id);
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return List.of(
            new Recipe(
                new ItemStack(this),
                Recipe.STATION_ALL_CRAFTING,
                new RecipeIngredient(Item.BONE)
            )
        );
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (level.getTile(x, y) != Tile.WHEAT.id) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        if (!mob.takeApproxStamina(2)) {
            return false;
        }

        if (!Tile.WHEAT.grow(level, x, y)) {
            return false;
        }

        EntitySmokeParticle.spawn(
            level, Level.toCenter(x), Level.toCenter(y),
            Color.get(151, 252,  353, 555),
            3, 6
        );

        mob.removeItem(this, 1);
        return true;
    }

    @Override
    public String getName() {
        return "BONEMEAL";
    }

    @Override
    public int getColor() {
        return Item.BONE.getColor();
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
