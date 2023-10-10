package com.coffee.coffeecraft.level.gen;

import com.coffee.coffeecraft.level.Level;

public abstract class StairsGenerator {
    public final Level upper, lower;

    public StairsGenerator(Level lower, Level upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public abstract void generate();
}
