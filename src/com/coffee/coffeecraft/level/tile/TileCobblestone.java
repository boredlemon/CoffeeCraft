package com.coffee.coffeecraft.level.tile;

import java.util.List;

import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.level.Level;

public class TileCobblestone extends TileRock {
    public TileCobblestone(int id) {
        super(id);
    }

    @Override
    public List<ItemStack> getDrops(Level level, int x, int y) {
        return List.of(new ItemStack(Item.ROCK));
    }

    @Override
    public int getBaseSpriteX() {
        return 16;
    }

    @Override
    public int getBaseSpriteY() {
        return 0;
    }

    @Override
    public int getBorderSpriteX() {
        return 18;
    }

    @Override
    public int getBorderSpriteY() {
        return 0;
    }

    @Override
    public int getHealth() {
        return (int) (super.getHealth() * 0.8);
    }

    @Override
    public int getColor() {
        return Tile.ROCK.getColor();
    }
}
