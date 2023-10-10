package com.coffee.coffeecraft.gui;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.util.Window;

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
