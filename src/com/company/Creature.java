package com.company;

public abstract class Creature {
    int health;
    int damage;
    String damageInfo;
    String name;

    public Creature(int health, int damage, String damageInfo, String name) {
        this.health = health;
        this.damage = damage;
        this.damageInfo = damageInfo;
        this.name = name;
    }
}
