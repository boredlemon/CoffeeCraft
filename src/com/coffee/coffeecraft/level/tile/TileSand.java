package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityItem;
import com.coffee.coffeecraft.entity.mob.EntityHumanoid;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.tool.ItemTool;
import com.coffee.coffeecraft.level.Level;

public class TileSand extends TileGround {
    public static final int COLOR = Color.get(110, 330, 550, 440),
        TRANSITION_COLOR = Color.get(322, 330, 550, 440),
        STEP_COLOR = Color.get(-1, -1, 440, 551);

    private static final int STEP_SPRITE_X = 6, STEP_SPRITE_Y = 1;

    public TileSand(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_SHOVEL;
    }

    @Override
    public boolean hit(Level level, int x, int y, Entity e) {
        if (this.id != Tile.SAND.id) {
            return super.hit(level, x, y, e);
        }

        EntityItem.spawn(
            level, new ItemStack(new ItemInstance(Item.SAND, 0), 1),
            Level.toCenter(x), Level.toCenter(y)
        );
        level.setTile(x, y, Tile.DIRT.id);
        return true;
    }

    @Override
    public void step(Level level, int x, int y, Entity e) {
        super.step(level, x, y, e);

        if (!(e instanceof EntityHumanoid)) {
            return;
        }

        level.setData(x, y, 1 + Global.random.nextInt(3));
    }

    @Override
    public void randomTick(Level level, int x, int y) {
        super.randomTick(level, x, y);

        int step = level.getData(x, y);
        if (step > 0) {
            level.setData(x, y, step - 1);
        }
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);

        if (level.getData(x, y) != 0) {
            boolean
                u = level.getTile(x, y - 1) != this.id,
                d = level.getTile(x, y + 1) != this.id,
                l = level.getTile(x - 1, y) != this.id,
                r = level.getTile(x + 1, y) != this.id;

            if (!u && !l) {
                Renderer.render(
                    STEP_SPRITE_X, STEP_SPRITE_Y,
                    Level.toPixel(x), Level.toPixel(y),
                    STEP_COLOR, Renderer.FLIP_NONE
                );
            }

            if (!d && !r) {
                Renderer.render(
                    STEP_SPRITE_X, STEP_SPRITE_Y,
                    Level.toCenter(x), Level.toCenter(y),
                    STEP_COLOR, Renderer.FLIP_NONE
                );
            }
        }
    }

    @Override
    public int getColor() {
        return COLOR;
    }

    @Override
    public int getTransitionColor() {
        return TRANSITION_COLOR;
    }
}
