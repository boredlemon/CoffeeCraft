package com.tornukah.microcraft.level.tile;

import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityItem;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.tool.ItemTool;
import com.tornukah.microcraft.level.Level;

public class TileCactus extends TileSand {
    public static int COLOR = Color.get(121, 141, 252, 252);

    public TileCactus(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_NONE;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_AXE | ItemTool.TYPE_SWORD;
    }

    @Override
    public boolean hit(Level level, int x, int y, Entity e) {
        EntityItem.spawn(
            level, new ItemStack(new ItemInstance(Item.CACTUS, 0), 1),
            Level.toCenter(x), Level.toCenter(y)
        );
        level.setTile(x, y, Tile.SAND.id);
        return true;
    }

    @Override
    public void bump(Level level, int x, int y, Entity e) {
        super.bump(level, x, y, e);

        if (e instanceof EntityMob) {
            EntityMob mob = (EntityMob) e;
            mob.hurt(1,  mob.getDirection().opposite());
        } else if (e instanceof EntityItem) {
            e.remove();
        }
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int getCollisionWidth() {
        return 9;
    }

    @Override
    public int getCollisionHeight() {
        return 14;
    }

    @Override
    public int getCollisionOffsetX() {
        return 4;
    }

    @Override
    public int getCollisionOffsetY() {
        return 1;
    }

    @Override
    public boolean collides(Level level, int x, int y, Entity e) {
        return true;
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                Renderer.render(
                    10 + i, 2 + j,
                    Level.toPixel(x) + (i * 8), Level.toPixel(y) + (j * 8),
                    COLOR, Renderer.FLIP_NONE
                );
            }
        }
    }

    @Override
    public Tile getBaseTile() {
        return Tile.SAND;
    }
}
