package com.company;

public abstract class Monsters extends Creature {
    public Monsters(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    @Override
    public String toString() {
        return name + ": Health: " + health + " Damage: " + damageInfo;
    }
}
