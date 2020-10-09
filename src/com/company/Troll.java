package com.company;

import java.util.Random;

public class Troll extends Monsters {

    public Troll(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    protected void makeYourSpecialNoise() {
        System.out.println("Gruntz!");
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The troll has " + health + " health and can hit for 7-11 damage");
    }

    public int getTrollDamage() {
        return damage = rand.nextInt( 11 - 7 + 1) + 7;
    }
}
