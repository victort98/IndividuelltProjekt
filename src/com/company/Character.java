package com.company;

public abstract class Character extends Creature {
    double level;
    int rage;

    public Character(int health, int damage, String damageInfo, String name, double level, int rage) {
        super(health, damage, damageInfo, name);
        this.level = level;
        this.rage = rage;
    }

    @Override
    public String toString() {
        return name + " the warrior has " + health + " health and is level " + level;
    }
}
