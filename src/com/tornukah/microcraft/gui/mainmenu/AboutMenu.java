package com.tornukah.microcraft.gui.mainmenu;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.gfx.Font;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.gui.DialogMenu;

public class AboutMenu extends DialogMenu {
    public AboutMenu() {
        super(
            "ABOUT",
            new String [] {
                "",
                Font.Colors.GREEN + "MICROCRAFT" + Font.Colors.WHITE + " REMAKE BY " + Font.Colors.GREEN + "Tornukah",
                "",
                "",
                Font.Colors.GREEN + "Coded in" + Font.Colors.WHITE + " JAVA! " + Font.Colors.GREEN + "XDDD",
                "FOR " + Font.Colors.ORANGE + "FUN" + Font.Colors.WHITE + "ONLY!!!",
                "",
                Font.Colors.GREY + "https://github.com/Tornukah",
                Font.Colors.GREY + "https://github.com/Tornukah"
            },
            Renderer.WIDTH / 8, Renderer.HEIGHT / 8,
            () -> Global.mainMenu.menu = Global.mainMenu.mainMenu
        );
    }

    @Override
    protected boolean shouldCenterText() {
        return true;
    }
}
