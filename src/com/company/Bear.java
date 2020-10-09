package com.company;

import java.util.Random;

public class Bear extends Monsters {

    public Bear(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    protected void makeYourSpecialNoise() {
        System.out.println("Grrrr");
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The bear has " + health + " health and can hit for 13-20 damage");
    }

    public int getBearDamage() {
        return damage = rand.nextInt( 20 - 13 + 1) + 13;
    }
}
