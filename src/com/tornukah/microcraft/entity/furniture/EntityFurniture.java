package com.tornukah.microcraft.entity.furniture;

import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityItem;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.entity.projectile.EntityProjectile;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.furniture.ItemFurniture;
import com.tornukah.microcraft.level.Level;
import com.tornukah.microcraft.level.tile.Tile;
import com.tornukah.microcraft.util.Direction;

public abstract class EntityFurniture extends Entity {
    private final ItemFurniture item;
    private int pushTime;

    public EntityFurniture(Level level, ItemFurniture item, int width, int height) {
        super(level);
        this.item = item;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render() {
        super.render();

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                Renderer.render(
                    this.getSpriteOffsetX() + i, this.getSpriteOffsetY() + j,
                    this.x + this.getRenderOffsetX() + (i * 8),
                    this.y + this.getRenderOffsetY() + (j * 8),
                    this.getColor(), Renderer.FLIP_NONE
                );
            }
        }
    }

    @Override
    public boolean collides(Entity e) {
        return true;
    }

    @Override
    public void collide(Entity e) {
        super.collide(e);

        if (e instanceof EntityMob) {
            this.pushTime++;

            if (this.pushTime == 3) {
                // push in the direction the mob is moving
                EntityMob mob = ((EntityMob) e);
                Direction d = mob.getDirection();
                this.move(d.x, d.y);
                this.pushTime = 0;
            }
        } else if (e instanceof EntityProjectile) {
            for (ItemStack s : this.getDrops()) {
                EntityItem.spawn(level, s, Level.toCenter(this.tileX), Level.toCenter(this.tileY));
            }
            this.remove();
        }
    }

    @Override
    public void onHit(Entity e) {
        if (!(e instanceof EntityMob)) {
            return;
        }

        for (ItemStack s : this.getDrops()) {
            EntityItem.spawn(level, s, Level.toCenter(this.tileX), Level.toCenter(this.tileY));
        }
        this.remove();
    }

    @Override
    public boolean canSwimIn(Tile tile, int x, int y) {
        return false;
    }

    protected List<ItemStack> getDrops() {
        return List.of(new ItemStack(new ItemInstance(this.item)));
    }

    public int getSpriteOffsetX() {
        return this.item.getTileSpriteX();
    }

    public int getSpriteOffsetY() {
        return this.item.getTileSpriteY();
    }

    public int getColor() {
        return this.item.getColor();
    }

    @Override
    public abstract boolean interact(Entity e);
}
