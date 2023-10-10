package com.coffee.coffeecraft.entity.ai;

import com.coffee.coffeecraft.entity.mob.EntityZombie;

public class AIZombie extends AIHostileHumanoid {
    public AIZombie(EntityZombie zombie) {
        super(zombie, 0.45 * zombie.strength, zombie.strength);
    }
}
