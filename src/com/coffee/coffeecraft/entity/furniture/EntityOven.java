package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.crafting.OvenMenu;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.level.Level;

public class EntityOven extends EntityFurniture {
    public EntityOven(Level level) {
        super(level, Item.OVEN, 15, 13);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new OvenMenu((EntityPlayer) e, this));
        return true;
    }
}
