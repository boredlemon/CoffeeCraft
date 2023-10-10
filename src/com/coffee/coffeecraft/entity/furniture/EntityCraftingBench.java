package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.crafting.BenchCraftingMenu;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.level.Level;

public class EntityCraftingBench extends EntityFurniture {
    public EntityCraftingBench(Level level) {
        super(level, Item.CRAFTING_BENCH, 15, 12);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new BenchCraftingMenu((EntityPlayer) e, this));
        return true;
    }
}
