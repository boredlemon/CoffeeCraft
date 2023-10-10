package com.coffee.coffeecraft.gui;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Font;

public class LoseMenu extends DialogMenu {
    public LoseMenu() {
        super(":(", new String[]{
            "",
            "YOU " + Font.Colors.RED + "DIED",
            "SCORE: " + Font.Colors.YELLOW + Global.game.score,
        }, 22, 8, () -> Global.setState(Global.StateType.MENU));
    }
}
