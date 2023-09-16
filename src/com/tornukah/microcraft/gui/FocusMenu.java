package com.tornukah.microcraft.gui;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.util.Window;

public class FocusMenu extends DialogMenu {
    private final Menu oldMenu;

    public FocusMenu(Menu oldMenu) {
        super("", new String[] { " ", "CLICK TO FOCUS!" }, 16, 5, () -> {});
        this.oldMenu = oldMenu;
    }

    @Override
    protected boolean shouldCenterText() {
        return true;
    }

    @Override
    protected boolean showPressAnyKey() {
        return false;
    }

    @Override
    public void update() {
        super.update();
        if (Window.hasFocus()) {
            Global.game.setMenu(this.oldMenu);
        }
    }
}
