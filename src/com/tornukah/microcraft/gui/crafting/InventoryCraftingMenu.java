package com.tornukah.microcraft.gui.crafting;

import com.tornukah.microcraft.Global;
import com.tornukah.microcraft.entity.EntityPlayer;
import com.tornukah.microcraft.gui.PlayerInventoryMenu;
import com.tornukah.microcraft.item.crafting.Recipe;
import com.tornukah.microcraft.util.ControlHandler;

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
