package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityItem;
import com.coffee.coffeecraft.entity.mob.EntityMob;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.tool.ItemTool;
import com.coffee.coffeecraft.level.Level;

public class TileTallGrass extends TileGrass {
    public static int COLOR = Color.get(252, 252, 353, 454);

    public TileTallGrass(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_ALL;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_HOE;
    }

    @Override
    public boolean hit(Level level, int x, int y, Entity e) {
        ItemTool tool = ((ItemTool) ((EntityMob) e).equipped.instance.item);

        if (Global.random.nextInt( (tool.type & ItemTool.TYPE_HOE) != 0 ? 2 : 4) == 0) {
            EntityItem.spawn(
                level, new ItemStack(new ItemInstance(Item.SEED, 0), 1),
                Level.toCenter(x), Level.toCenter(y)
            );
        }
        level.setTile(x, y, Tile.GRASS.id);
        return true;
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);
        Global.random.setSeed((x * 43) ^ (y * 117));
        Renderer.render(
            4 + Global.random.nextInt(2),
            0 + Global.random.nextInt(2),
            Level.toPixel(x) + (Global.random.nextInt(1) * 8),
            Level.toPixel(y) + (Global.random.nextInt(1) * 8),
            COLOR, Global.random.nextBoolean() ? Renderer.FLIP_X : Renderer.FLIP_NONE
        );
    }

    @Override
    public Tile getBaseTile() {
        return Tile.GRASS;
    }
}
