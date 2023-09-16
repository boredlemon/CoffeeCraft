package com.tornukah.microcraft.entity.mob;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.entity.ai.AIAirWizard;
import com.tornukah.microcraft.entity.attack.WizardAttack;
import com.tornukah.microcraft.entity.particle.EntitySmokeParticle;
import com.tornukah.microcraft.entity.projectile.EntityProjectile;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.gui.WinMenu;
import com.tornukah.microcraft.item.Inventory;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;
import com.tornukah.microcraft.sound.Sound;

public class EntityAirWizard extends EntityHumanoid {
    public final double strength = 1.0 * Global.game.difficulty;

    public WizardAttack attack;

    public EntityAirWizard(Level level) {
        super(level, Inventory.NONE);
        this.health = this.getMaxHealth();
        this.stamina = this.getMaxStamina();
        this.ai = new AIAirWizard(this);
    }

    @Override
    public void die() {
        super.die();
        Sound.WIZARD_DEATH.play();
        Global.game.score += 5000;
        Global.game.setMenu(new WinMenu());
    }

    @Override
    public boolean hurt(int amount) {
        return super.hurt(amount == 1 ? 0 : amount);
    }

    @Override
    public boolean collides(Entity e) {
        return !(e instanceof EntityProjectile) && super.collides(e);
    }

    @Override
    public void collide(Entity e) {
        if (e instanceof EntityPlayer) {
            this.hit(e);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (Global.random.nextInt(10) == 0) {
            EntitySmokeParticle.spawn(this.level, this.getCenterX(), this.getCenterY(), Tile.CLOUD.getColor(), 1, 4);
        }

        if (this.attack != null) {
            if (this.attack.done()) {
                this.attack = null;
            } else {
                this.attack.tick();
            }
        }
    }

    @Override
    public int getHitDamage(Entity e) {
        return (int) ((2 + Global.random.nextInt(5)) * this.strength);
    }

    @Override
    public int getBaseSpriteX() {
        return 8;
    }

    @Override
    public int getBaseSpriteY() {
        return 9;
    }

    @Override
    public int getCarrySpriteX() {
        return 8;
    }

    @Override
    public int getCarrySpriteY() {
        return 9;
    }

    @Override
    public int getColor() {
        return Color.get(111, 224, 441, 555);
    }

    @Override
    public int getHurtColor() {
        return Color.get(444, 335, 552, 555);
    }

    @Override
    public double getStaminaRechargeRate() {
        return 0.3;
    }

    @Override
    public int getMaxStamina() {
        return (int) (this.strength * 100);
    }

    @Override
    public int getMaxHealth() {
        return (int) (this.strength * 80);
    }
}
