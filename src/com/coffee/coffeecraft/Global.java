package com.coffee.coffeecraft;

import java.util.Random;

import com.coffee.coffeecraft.gfx.Color;
import com.coffee.coffeecraft.gfx.Renderer;
import com.coffee.coffeecraft.gui.mainmenu.MainMenu;
import com.coffee.coffeecraft.sound.Sound;
import com.coffee.coffeecraft.util.Time;
import com.coffee.coffeecraft.util.Window;

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
