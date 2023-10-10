package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.crafting.AnvilCraftingMenu;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.level.Level;

public class EntityAnvil extends EntityFurniture {
    public EntityAnvil(Level level) {
        super(level, Item.ANVIL, 15, 10);
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new AnvilCraftingMenu((EntityPlayer) e, this));
        return true;
    }
}
