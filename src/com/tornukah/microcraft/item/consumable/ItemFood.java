package com.tornukah.microcraft.item.consumable;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.entity.particle.EntitySmashParticle;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.sound.Sound;

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
