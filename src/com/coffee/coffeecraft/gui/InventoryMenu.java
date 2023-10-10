package com.coffee.coffeecraft.gui;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.coffee.coffeecraft.item.Inventory;
import com.coffee.coffeecraft.item.Item;
import com.coffee.coffeecraft.item.ItemStack;
import com.coffee.coffeecraft.util.ControlHandler;

public class InventoryMenu extends ItemSelectMenu {
    protected final Inventory inventory;

    public InventoryMenu(Inventory inventory, boolean leftSide) {
        super(leftSide, ControlHandler.MENU_UP, ControlHandler.MENU_DOWN);
        this.inventory = inventory;
    }

    @Override
    public List<ItemStack> getItems() {
        // give a sorted list of items with POW GLOVE always on top
        return inventory.stacks.stream()
            .filter(s -> s.instance.item.showInMenu())
            .sorted(Comparator
                .<ItemStack, Boolean>comparing(s -> s.instance.item.id != Item.GLOVE.id)
                .thenComparing(s -> s.instance.item.getName()))
            .collect(Collectors.toList());
    }

    @Override
    public int getItemTextColor(int index) {
        return 555;
    }

    @Override
    public String getName() {
        return "INVENTORY";
    }
}
