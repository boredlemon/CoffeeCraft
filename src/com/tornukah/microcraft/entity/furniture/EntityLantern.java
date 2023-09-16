package com.tornukah.microcraft.entity.furniture;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.gfx.Light;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.level.Level;

public class EntityLantern extends EntityFurniture {
    public static final int LIGHT_POWER = 6;

    public EntityLantern(Level level) {
        super(level, Item.LANTERN, 13, 13);
    }

    @Override
    public int getRenderOffsetX() {
        return -2;
    }

    @Override
    public int getRenderOffsetY() {
        return -3;
    }

    @Override
    public Light getLight() {
        return new Light(
            this.getCenterX(),
            this.getCenterY(),
            LIGHT_POWER
        );
    }

    @Override
    public boolean interact(Entity e) {
        ItemStack s = new ItemStack(new ItemInstance(Item.LANTERN, 0), 1);

        if (e instanceof EntityMob && ((EntityMob) e).inventory.add(s)) {
            EntityMob mob = (EntityMob) e;
            mob.equipped = s;
            this.remove();
            return true;
        }

        return false;
    }
}
