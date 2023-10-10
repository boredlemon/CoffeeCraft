package com.coffee.coffeecraft.level.tile;

import java.util.ArrayList;
import java.util.List;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.particle.EntitySmashParticle;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.tool.ItemTool;
import com.coffee.coffeecraft.level.Level;

public class TileTree extends TileGrass {
    private static final int COLOR = Color.get(110, 220, 141, 252);

    private static final int SPRITE_X = 8, SPRITE_Y = 2;

    public TileTree(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_PICKAXE | ItemTool.TYPE_OMNI;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

    @Override
    public int getHealth() {
        return 60;
    }

    @Override
    public List<ItemStack> getDrops(Level level, int x, int y) {
        List<ItemStack> result = new ArrayList<>();
        for (int i = Global.random.nextInt(2) + 1; i >= 0; i--) {
            result.add(new ItemStack(new ItemInstance(Item.WOOD, 0), 1));
        }

        if (Global.random.nextInt(5) == 0) {
            result.add(new ItemStack(new ItemInstance(Item.APPLE, 0), 1));
        }

        if (Global.random.nextInt(3) == 0) {
            result.add(new ItemStack(new ItemInstance(Item.SAPLING, 0), 1));
        }

        return result;
    }

    @Override
    public void destroy(Level level, int x, int y, Entity e) {
        super.destroy(level, x, y, e);
        EntitySmashParticle.spawn(level, Level.toCenter(x), Level.toCenter(y), COLOR, 2, 4);
        level.setTile(x, y, Tile.GRASS.id);
    }

    @Override
    public boolean collides(Level level, int x, int y, Entity e) {
        return true;
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);

        boolean
            u = level.getTile(x, y - 1) == this.id,
            d = level.getTile(x, y + 1) == this.id,
            l = level.getTile(x - 1, y) == this.id,
            r = level.getTile(x + 1, y) == this.id,
            ul = level.getTile(x - 1, y - 1) == this.id,
            dl = level.getTile(x - 1, y + 1) == this.id,
            ur = level.getTile(x + 1, y - 1) == this.id,
            dr = level.getTile(x + 1, y + 1) == this.id;

        int px = Level.toPixel(x), py = Level.toPixel(y);

        if (u && ul && l) {
            Renderer.render(SPRITE_X + 1, SPRITE_Y + 1, px + 0, py + 0, COLOR, Renderer.FLIP_NONE);
        } else {
            Renderer.render(SPRITE_X + 0, SPRITE_Y + 0, px + 0, py + 0, COLOR, Renderer.FLIP_NONE);
        }

        if (u && ur && r) {
            Renderer.render(SPRITE_X + 1, SPRITE_Y + 2, px + 8, py + 0, COLOR, Renderer.FLIP_NONE);
        } else {
            Renderer.render(SPRITE_X + 1, SPRITE_Y + 0, px + 8, py + 0, COLOR, Renderer.FLIP_NONE);
        }

        if (d && dl && l) {
            Renderer.render(SPRITE_X + 1, SPRITE_Y + 2, px + 0, py + 8, COLOR, Renderer.FLIP_NONE);
        } else {
            Renderer.render(SPRITE_X + 0, SPRITE_Y + 1, px + 0, py + 8, COLOR, Renderer.FLIP_NONE);
        }

        if (d && dr && r) {
            Renderer.render(SPRITE_X + 1, SPRITE_Y + 1, px + 8, py + 8, COLOR, Renderer.FLIP_NONE);
        } else {
            Renderer.render(SPRITE_X + 0, SPRITE_Y + 2, px + 8, py + 8, COLOR, Renderer.FLIP_NONE);
        }
    }

    @Override
    public Tile getBaseTile() {
        return Tile.GRASS;
    }
}
