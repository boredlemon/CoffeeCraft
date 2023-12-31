package com.coffee.coffeecraft.gui;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Font;

public class WinMenu extends DialogMenu {
    private int ticks;

    public WinMenu() {
        super("YAY!", new String[]{
            "",
            "YOU WIN! ",
            "THE EVIL " + Font.Colors.RED + "AIR WIZARD",
            "HAS BEEN " + Font.Colors.YELLOW + "BESTED.",
            "SCORE: " + Font.Colors.YELLOW + Global.game.score,
        }, 22, 10, () -> Global.setState(Global.StateType.MENU));
    }

    @Override
    public void tick() {
        if (++this.ticks > 120) {
            super.tick();
        }
    }
}
