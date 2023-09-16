package com.tornukah.microcraft;

import java.util.Random;

import com.tornukah.microcraft.gfx.Color;
import com.tornukah.microcraft.gfx.Renderer;
import com.tornukah.microcraft.gui.mainmenu.MainMenu;
import com.tornukah.microcraft.sound.Sound;
import com.tornukah.microcraft.util.Time;
import com.tornukah.microcraft.util.Window;

// Encapsulates (statically) all game state
public class Global {
    public enum StateType {
        MENU, GAME
    }

    public static StateType currentStateType;
    public static GameState game;
    public static MainMenuState mainMenu;
    public static State currentState;
    public static Random random = new Random(Time.now());
    public static long ticks = 0, frames = 0;

    public static void setState(StateType state) {
        Global.currentStateType = state;

        Renderer.reset();

        switch (state) {
            case GAME -> {
                Sound.START.play();
                Global.game = new GameState(
                    Global.mainMenu.difficultySelectMenu.getSelectedDifficulty(),
                    Color.get(
                        Global.mainMenu.colorSelectMenu.colors
                    ));
                Global.mainMenu.menu = Global.mainMenu.loadingMenu;
                Global.mainMenu.loadingMenu.setProgress("LOADING", 0.0);
                Global.game.init();
                Global.currentState = Global.game;
            }
            case MENU -> {
                Global.game = null;
                Global.mainMenu.mainMenu = new MainMenu();
                Global.mainMenu.menu = Global.mainMenu.mainMenu;
                Global.currentState = Global.mainMenu;
            }
        }
    }

    public static void setLoadingInfo(String text, double progress) {
        Global.mainMenu.loadingMenu.progress = progress;
        Global.mainMenu.loadingMenu.text = text;

        Renderer.clear();
        Global.mainMenu.loadingMenu.render();
        Window.renderFrame();
    }
}
