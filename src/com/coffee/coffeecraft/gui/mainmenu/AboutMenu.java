package com.coffee.coffeecraft.gui.mainmenu;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.gfx.Font;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.gui.DialogMenu;

public class AboutMenu extends DialogMenu {
    public AboutMenu() {
        super(
            "ABOUT",
            new String [] {
                "",
                Font.Colors.GREEN + "COFFEECRAFT" + Font.Colors.WHITE + " Made by " + Font.Colors.GREEN + "Coffee",
                "",
                "",
                Font.Colors.GREEN + "Coded in" + Font.Colors.WHITE + " JAVA! " + Font.Colors.GREEN + "XDDD",
                "FOR " + Font.Colors.ORANGE + "FUN" + Font.Colors.WHITE + "ONLY!!!",
                "",
                Font.Colors.GREY + "https://github.com/coffee",
                Font.Colors.GREY + "https://github.com/coffee"
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
