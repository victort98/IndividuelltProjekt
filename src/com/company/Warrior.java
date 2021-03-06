package com.company;

import java.util.Random;

public class Warrior extends Character{

    private static Warrior single_instance = null;

    private Warrior (int health, int damage, String damageInfo, String name, double level, int rage) {
        super(health, damage, damageInfo, name, level, rage);
    }

    public static Warrior getInstance() {
        if(single_instance == null) {
            single_instance = new Warrior(25, 0, "4-7", "", 1, 50);
        }
        return single_instance;
    }

    Random rand = new Random();

    public int getDamage() {
        return damage = rand.nextInt( 7 - 4 + 1) + 4;
    }

    public int getStrongerDamage() {
        return damage = rand.nextInt(12 - 8 + 1) + 8;
    }
}
