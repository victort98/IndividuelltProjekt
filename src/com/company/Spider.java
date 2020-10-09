package com.company;

import java.util.Random;

public class Spider extends Monsters{

    public Spider(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    protected void makeYourSpecialNoise() {
        System.out.println("Screeech!");
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The spider has " + health + " health and can hit for 3-5 damage");
    }

    public int getSpiderDamage() {
        return damage = rand.nextInt(5 - 3 + 1) + 3;
    }
}
