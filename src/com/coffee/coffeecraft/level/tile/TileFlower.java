package com.coffee.coffeecraft.level.tile;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.Entity;
import com.coffee.coffeecraft.entity.EntityItem;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemInstance;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.item.tool.ItemTool;
import com.coffee.coffeecraft.level.Level;

public abstract class TileFlower extends TileGrass {

    public TileFlower(int id) {
        super(id);
    }

    @Override
    public int getUsableTools() {
        return ItemTool.TYPE_ALL;
    }

    @Override
    public int getIdealTools() {
        return ItemTool.TYPE_HOE | ItemTool.TYPE_SWORD;
    }

    @Override
    public boolean hit(Level level, int x, int y, Entity e) {
        EntityItem.spawn(
            level, new ItemStack(new ItemInstance(this.getDrop(), 0), 1),
            Level.toCenter(x), Level.toCenter(y)
        );
        level.setTile(x, y, Tile.GRASS.id);
        return true;
    }

    @Override
    public void render(Level level, int x, int y) {
        super.render(level, x, y);
        Global.random.setSeed((x * 31) ^ (y * 43));
        Renderer.render(
            2 + Global.random.nextInt(2),
            0 + Global.random.nextInt(2),
            Level.toPixel(x) + (Global.random.nextInt(2) * 8),
            Level.toPixel(y) + (Global.random.nextInt(2) * 8),
            this.getFlowerColor(), Renderer.FLIP_NONE
        );
    }

    @Override
    public Tile getBaseTile() {
        return Tile.GRASS;
    }

    public abstract Item getDrop();

    public abstract int getFlowerColor();
}
