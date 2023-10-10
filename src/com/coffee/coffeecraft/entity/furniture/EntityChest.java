package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityItem;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.ChestMenu;
import com.coffee.coffeecraft.item.Inventory;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;

public class EntityChest extends EntityFurniture {
    public Inventory inventory = new Inventory(512);

    public EntityChest(Level level) {
        super(level, Item.CHEST, 15, 13);
    }

    @Override
    public boolean hit(Entity e) {
        if (super.hit(e)) {
            for (ItemStack s : this.inventory.stacks) {
                EntityItem.spawn(this.level, s, Level.toCenter(e.tileX), Level.toCenter(e.tileY));
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean interact(Entity e) {
        if (!(e instanceof EntityPlayer)) {
            return false;
        }

        Global.game.setMenu(new ChestMenu((EntityPlayer) e, this));
        return true;
    }
}
