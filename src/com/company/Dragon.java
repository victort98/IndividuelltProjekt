package com.company;

import java.util.Random;

public class Dragon extends Monsters implements MonsterInformation {

    public Dragon(int health, int damage, String damageInfo, String name) {
        super(health, damage, damageInfo, name);
    }

    protected void makeYourSpecialNoise() {
        System.out.println("GROOAAARRR");
    }

    private Random rand = new Random();

    @Override
    public void information() {
        System.out.println("The dragon has " + health + " health and can hit for 17-25 damage");
    }

    public int getDragonDamage() {
        return damage = rand.nextInt( 25 - 17 + 1) + 17;
    }
}
