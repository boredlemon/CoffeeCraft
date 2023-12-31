package com.coffee.coffeecraft.entity.ai;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.attack.WizardAttackBeam;
import com.coffee.coffeecraft.entity.attack.WizardAttackBurst;
import com.coffee.coffeecraft.entity.attack.WizardAttackSpiral;
import com.coffee.coffeecraft.entity.mob.EntityAirWizard;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.sound.Sound;
import com.coffee.coffeecraft.util.Direction;

public class AIAirWizard extends AIHostileHumanoid {
    private long lastAttack;
    private final EntityAirWizard wizard;

    private Direction randomDirection;

    public AIAirWizard(EntityAirWizard wizard) {
        super(wizard, 0.75, 3.0 * wizard.strength);
        this.wizard = wizard;
        this.lastAttack = Global.ticks;
    }

    @Override
    public void tick() {
        if (this.wizard.attack == null) {
            super.tick();
        } else {
            // move randomly
            if (this.randomDirection == null || Global.random.nextInt(80) == 0) {
                this.randomDirection = Direction.ALL.get(Global.random.nextInt(4));
            }

            this.moveTowards(
                this.wizard.x + this.randomDirection.x * 10,
                this.wizard.y + this.randomDirection.y * 10
            );
        }

        if ((Global.ticks - this.lastAttack) > 120 + Global.random.nextInt(480)) {
            this.wizard.attack = switch (Global.random.nextInt(3)) {
                case 0 -> new WizardAttackBurst(this.wizard);
                case 1 -> new WizardAttackSpiral(this.wizard);
                default -> new WizardAttackBeam(this.wizard);
            };

            if (Renderer.inBounds(this.wizard.getCenterX(), this.wizard.getCenterY())) {
                Sound.WIZARD_ATTACK.play();
            }

            this.lastAttack = Global.ticks;
        }
    }
}
