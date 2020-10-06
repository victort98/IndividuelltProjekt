package com.company;

import java.util.Random;

public class Orc extends Monsters {

    public Orc(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The orc has " + health + " health and can hit for 15-22 damage");
    }

    public int getOrcDamage() {
        return damage = rand.nextInt( 22 - 15 + 1) + 15;
    }
}
