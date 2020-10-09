package com.company;

import java.util.Random;

public class Warrior extends Character{

    public Warrior (int health, int damage, String damageInfo, String name, double level, int rage) {
        super(health, damage, damageInfo, name, level, rage);
    }

    @Override
    public void information() {
    }

    public int getDamage() {
        Random rand = new Random();
        return damage = rand.nextInt( 7 - 4 + 1) + 4;
    }
}
