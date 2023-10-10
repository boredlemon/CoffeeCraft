package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.crafting.FurnaceMenu;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.level.Level;

public class EntityFurnace extends EntityFurniture {
    public EntityFurnace(Level level) {
        super(level, Item.FURNACE, 15, 14);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new FurnaceMenu((EntityPlayer) e, this));
        return true;
    }
}
