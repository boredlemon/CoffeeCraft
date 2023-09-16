package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityItem;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.ChestMenu;
import com.tornukah.microcraft.item.Inventory;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.level.Level;

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
