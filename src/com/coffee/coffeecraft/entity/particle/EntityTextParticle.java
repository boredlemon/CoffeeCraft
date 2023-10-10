package com.coffee.coffeecraft.entity.particle;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.gfx.Font;
import com.coffee.coffeecraft.level.Level;

public class EntityTextParticle extends EntityParticle {
    private final String text;
    private final int color;

    public EntityTextParticle(Level level, int x, int y, String text, int color) {
        super(level, x, y);
        this.text = text;
        this.color = color;
        this.timeToLive = 30 + Global.random.nextInt(30);
    }

    public static void spawn(Level level, int x, int y, String text, int color) {
        level.addEntity(new EntityTextParticle(level, x, y, text, color));
    }

    @Override
    public void render() {
        Global.random.setSeed(this.id);
        Font.render(this.text, this.getRenderX() + 1, this.getRenderY() + 1, Color.add(this.color, -222));
        Font.render(this.text, this.getRenderX(), this.getRenderY(), this.color);
    }
}
