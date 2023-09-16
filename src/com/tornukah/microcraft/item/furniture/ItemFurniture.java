package com.tornukah.microcraft.item.furniture;

import java.util.List;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.level.Level;

public abstract class ItemFurniture extends Item {
    public ItemFurniture(int id) {
        super(id);
    }

    @Override
    public void renderCarry(ItemInstance instance, Level Level, Entity e) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                Renderer.render(
                    this.getTileSpriteX() + i, this.getTileSpriteY() + j,
                    e.x + e.getRenderOffsetX() + (i * 8), e.y + e.getRenderOffsetY() - 14 + (j * 8),
                    this.getColor(), Renderer.FLIP_NONE
                );
            }
        }
    }

    @Override
    public boolean carry(Entity e) {
        return true;
    }

    @Override
    public boolean use(ItemInstance instance, Level level, int x, int y, Entity e) {
        if (!(e instanceof EntityMob)) {
            return false;
        }

        EntityMob mob = (EntityMob) e;
        Entity fe = this.createEntity(level);
        fe.x = Level.toPixel(mob.getFacingTileX());
        fe.y = Level.toPixel(mob.getFacingTileY());

        // cannot place if tile colliding
        if (level.getTileCollisions(fe).size() > 0) {
            return false;
        }

        // cannot place if entity which is not placing is colliding
        List<Entity> collidingEntities = level.getEntityCollisions(fe);
        if (collidingEntities.size() > 1 ||
            (collidingEntities.size() == 1 && collidingEntities.get(0) != e)) {
            return false;
        }

        // remove from inventory
        mob.removeItem(instance.item, 1);

        // place in world
        level.addEntity(fe);
        return true;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    public abstract Entity createEntity(Level level);

    public abstract int getTileSpriteX();

    public abstract int getTileSpriteY();
}
