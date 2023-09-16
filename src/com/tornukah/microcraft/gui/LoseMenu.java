package com.tornukah.microcraft.gui;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.gfx.Font;

public class LoseMenu extends DialogMenu {
    public LoseMenu() {
        super(":(", new String[]{
            "",
            "YOU " + Font.Colors.RED + "DIED",
            "SCORE: " + Font.Colors.YELLOW + Global.game.score,
        }, 22, 8, () -> Global.setState(Global.StateType.MENU));
    }
}
