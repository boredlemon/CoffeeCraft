package com.coffee.coffeecraft.entity.furniture;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.gfx.Light;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;

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
