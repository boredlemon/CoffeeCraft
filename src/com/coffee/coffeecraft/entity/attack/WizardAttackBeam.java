package com.coffee.coffeecraft.entity.attack;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.ai.AIHostileMob;
import com.coffee.coffeecraft.entity.mob.EntityAirWizard;
import com.coffee.coffeecraft.entity.projectile.EntityAirBlast;

public class WizardAttackBeam extends WizardAttack {
    public WizardAttackBeam(EntityAirWizard wizard) {
        super(wizard, 60);
    }

    @Override
    public void tick() {
        super.tick();

        if ((Global.ticks % 2) != 0) {
            return;
        }

        AIHostileMob ai = (AIHostileMob) this.wizard.ai;
        if (ai.target != null) {
            this.wizard.level.addEntity(
                new EntityAirBlast(
                    this.wizard.level, this.wizard,
                    this.wizard.getCenterX(), this.wizard.getCenterY(),
                    ai.target.getCenterX(), ai.target.getCenterY(),
                    1.4,
                    (int) (3 * this.wizard.strength))
            );
        }
    }
}
