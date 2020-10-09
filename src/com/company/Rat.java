package com.company;

import java.util.Random;

public class Rat extends Monsters{

    public Rat(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    protected void makeYourSpecialNoise() {
        System.out.println("Squeak, Squeak");
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The rat has " + health + " health and can hit for 1-3 damage");
    }

    public int getRatDamage() {
        return damage = rand.nextInt(3 - 1 + 1) + 1;
    }
}
