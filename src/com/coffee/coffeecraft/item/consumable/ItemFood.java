package com.coffee.coffeecraft.item.consumable;

import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.entity.particle.EntitySmashParticle;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.sound.Sound;

public abstract class ItemFood extends ItemConsumable {
    public ItemFood(int id) {
        super(id);
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (!(e instanceof EntityMob)) {
            return false;
        }

        EntityMob mob = ((EntityMob) e);
        mob.heal(this.getFoodValue());
        mob.removeItem(this, 1);

        Sound.EQUIP.play();
        EntitySmashParticle.spawn(level, e.getCenterX(), e.getCenterY(), this.getColor(), 3, 8);

        return true;
    }

    public abstract int getFoodValue();
}
