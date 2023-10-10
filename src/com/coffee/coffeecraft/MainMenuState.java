package com.coffee.coffeecraft;

import com.coffee.coffeecraft.gui.ColorSelectMenu;
import com.coffee.coffeecraft.gui.DifficultySelectMenu;
import com.coffee.coffeecraft.gui.Menu;
import com.coffee.coffeecraft.gui.mainmenu.AboutMenu;
import com.coffee.coffeecraft.gui.mainmenu.HowToPlayMenu;
import com.coffee.coffeecraft.gui.mainmenu.LoadingMenu;
import com.coffee.coffeecraft.gui.mainmenu.MainMenu;

public class MainMenuState implements State {
    public Menu menu;

    public MainMenu mainMenu;
    public LoadingMenu loadingMenu;
    public HowToPlayMenu howToPlayMenu;
    public AboutMenu aboutMenu;
    public ColorSelectMenu colorSelectMenu;
    public DifficultySelectMenu difficultySelectMenu;

    public MainMenuState() {
        this.mainMenu = new MainMenu();
        this.loadingMenu = new LoadingMenu();
        this.howToPlayMenu = new HowToPlayMenu();
        this.aboutMenu = new AboutMenu();
        this.colorSelectMenu = new ColorSelectMenu();
        this.difficultySelectMenu = new DifficultySelectMenu();
        this.menu = this.mainMenu;
    }

    @Override
    public void tick() {
        this.menu.tick();
    }

    @Override
    public void update() {
        this.menu.update();
    }

    @Override
    public void render() {
        this.menu.render();
    }
}
