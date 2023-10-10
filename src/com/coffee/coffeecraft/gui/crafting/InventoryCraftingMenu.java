package com.coffee.coffeecraft.gui.crafting;

import com.coffee.coffeecraft.Global;
import com.coffee.coffeecraft.entity.EntityPlayer;
import com.coffee.coffeecraft.gui.PlayerInventoryMenu;
import com.coffee.coffeecraft.item.crafting.Recipe;
import com.coffee.coffeecraft.util.ControlHandler;

public class InventoryCraftingMenu extends CraftingMenu {
    public InventoryCraftingMenu(EntityPlayer player) {
        super(player);
    }

    @Override
    public void tick() {
        super.tick();

        if (ControlHandler.TOGGLE_CRAFTING.pressedTick()) {
            Global.game.setMenu(null);
        }

        if (ControlHandler.INTERACT.pressedTick()) {
            // allow direct crafting -> inventory transitions
            Global.game.setMenu(new PlayerInventoryMenu(this.player, true));
        }
    }

    @Override
    public int getStation() {
        return Recipe.STATION_INVENTORY;
    }

    @Override
    public String getName() {
        return "CRAFTING";
    }
}
