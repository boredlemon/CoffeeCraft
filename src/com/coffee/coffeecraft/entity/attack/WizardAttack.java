package com.coffee.coffeecraft.entity.attack;

import com.coffee.coffeecraft.entity.mob.EntityAirWizard;

public abstract class WizardAttack {
    protected final EntityAirWizard wizard;
    public int time;

    public WizardAttack(EntityAirWizard wizard, int time) {
        this.wizard = wizard;
        this.time = time;
    }

    public boolean done() {
        return this.time <= 0;
    }

    public void tick() {
        this.time--;
    }
}
