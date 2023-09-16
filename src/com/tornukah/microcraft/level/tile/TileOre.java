package com.tornukah.microcraft.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.Entity;
import com.tornukah.microcraft.entity.EntityItem;
import com.tornukah.microcraft.entity.mob.EntityMob;
import com.tornukah.microcraft.entity.particle.EntitySmashParticle;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.item.Item;
import com.tornukah.microcraft.item.ItemInstance;
import com.tornukah.microcraft.item.ItemStack;
import com.tornukah.microcraft.item.tool.ItemTool;
import com.tornukah.microcraft.level.Level;

public class TileOre extends TileStone {
    private final int health;
    private final Item item;

    public TileOre(int id, int health, Item item) {
        super(id);
        this.health = health;
        this.item = item;
    }

    @Override
    public boolean isSolid() {
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
    public boolean collides(Level level, int x, int y, Entity e) {
        return true;
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

    @Override
    public List<ItemStack> getDrops(Level level, int x, int y) {
        List<ItemStack> result = new ArrayList<>();
        for (int i = Global.random.nextInt(3) + 1; i >= 0; i--) {
            result.add(new ItemStack(new ItemInstance(this.item, 0), 1));
        }
        return result;
    }

    @Override
    public void destroy(Level level, int x, int y, Entity e) {
        super.destroy(level, x, y, e);
        EntitySmashParticle.spawn(level, Level.toCenter(x), Level.toCenter(y), this.item.getColor(), 3, 5);
        level.setTile(x, y, Tile.STONE.id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_OMNI;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                Renderer.render(
                    12 + i, 6 + j,
                    Level.toPixel(x) + (i * 8), Level.toPixel(y) + (j * 8),
                    this.item.getColor(), Renderer.FLIP_NONE
                );
            }
        }
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public Tile getBaseTile() {
        return Tile.STONE;
    }
}
