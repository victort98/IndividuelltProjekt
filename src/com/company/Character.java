package com.company;

public abstract class Character extends Creature {
    double level;
    int rage;

    public Character(int health, int damage, String damageInfo, String name, double level, int rage) {
        super(health, damage, damageInfo, name);
        this.level = level;
        this.rage = rage;
    }

    public String warriorInformation(){
        return "The warrior uses his mighty sword to kill his enemies\n" +
        "Base health and damage: \n" +
        "Health: 25\n" +
        "Damage: " + damageInfo;
    }


    public void setDamageInfo() {
        this.damageInfo = "8-12";
    }

    public void visitor(CallbackWarrior callback) {
        callback.call(this);
    }
}
