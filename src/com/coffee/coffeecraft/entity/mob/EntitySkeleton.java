package com.coffee.coffeecraft.entity.mob;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityItem;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.entity.ai.AISkeleton;
import com.coffee.coffeecraft.entity.particle.EntitySmashParticle;
import com.coffee.coffeecraft.entity.projectile.EntityArrow;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.item.Inventory;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;
import com.coffee.coffeecraft.level.tile.Tile;

public class EntitySkeleton extends EntityHumanoid {
    private static final Item[] LOOT_TABLE = {
        Item.GEM, Item.GOLD_INGOT,
        Item.COAL, Item.COAL, Item.IRON_INGOT, Item.IRON_INGOT,
        Item.COAL, Item.COAL, Item.IRON_ORE, Item.IRON_ORE, Item.IRON_ORE,
        Item.GLASS, Item.GLASS, Item.GLASS, Item.PIE, Item.IRON_ORE,
        Item.ROCK, Item.ROCK, Item.ROCK, Item.ROCK, Item.SAND, Item.SAND, Item.SAND
    };

    private long lastShotTicks;
    public final double strength;

    public EntitySkeleton(Level level, int x, int y, double strength) {
        super(level, new Inventory(4));
        this.x = x;
        this.y = y;
        this.strength = strength * Global.game.difficulty;
        this.ai = new AISkeleton(this);
        this.health = this.getMaxHealth();
        this.stamina = this.getMaxStamina();
    }

    public static EntitySkeleton createSkeleton(Level level) {
        EntitySkeleton skeleton = new EntitySkeleton(level, 0, 0, 1.0);
        EntityHumanoid.giveRandomEquipment(skeleton, 1, true, false);
        return skeleton;
    }

    private boolean canShoot() {
        return (Global.ticks - this.lastShotTicks) >= Math.max(180 - (30 * this.strength), 80);
    }

    public void shoot(int dx, int dy) {
        if (Tile.TILES[this.level.getTile(this.getFacingTileX(), this.getFacingTileY())].isSolid()) {
            // only shoot if facing tile is empty
            return;
        } else if (!this.canShoot()) {
            return;
        }

        this.updateAnimationFrame(true);
        this.lastShotTicks = Global.ticks;
        this.level.addEntity(new EntityArrow(
            this.level, this,
            this.getCenterX(), this.getCenterY(),
            dx, dy,
            2.0,
            (int) (1 * this.strength + Global.random.nextInt((int) (2 * this.strength)))
        ));
    }

    @Override
    protected int getAnimationFrameTicks() {
        return Math.max(12 - ((int) (2.0 / this.strength)), 6);
    }

    @Override
    public void die() {
        super.die();
        EntitySmashParticle.spawn(this.level, this.x, this.y, this.getColor(), 4, 8);

        for (int i = Global.random.nextInt(3); i > 0; i--) {
            EntityItem.spawn(
                this.level,
                new ItemStack(new ItemInstance(Item.BONE)),
                this.x, this.y
            );
        }

        if (Global.random.nextBoolean()) {
            EntityItem.spawn(
                this.level,
                new ItemStack(new ItemInstance(LOOT_TABLE[Global.random.nextInt(LOOT_TABLE.length)], 0), 1),
                this.x, this.y
            );
        }

        Global.game.score += 25 * this.strength;
    }

    @Override
    public int getHitDamage(Entity e) {
        return 1;
    }

    @Override
    public void collide(Entity e) {
        super.collide(e);

        if (e instanceof EntityPlayer) {
            this.hit(e);
            e.onHit(this);
        }
    }

    @Override
    public int getColor() {
        return Color.get(331, 555, 555, 554);
    }

    @Override
    public int getHurtColor() {
        return Color.get(444, 555, 555, 554);
    }

    @Override
    public double getStaminaRechargeRate() {
        return 0.2;
    }

    @Override
    public int getMaxStamina() {
        return (int) (this.strength * 10);
    }

    @Override
    public int getMaxHealth() {
        return (int) (this.strength * 10);
    }
}
