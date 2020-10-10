package com.company;

public class MonsterInformationMaker {
    private MonsterInformation rat;
    private MonsterInformation spider;
    private MonsterInformation troll;
    private MonsterInformation bear;
    private MonsterInformation orc;
    private MonsterInformation dragon;

    public MonsterInformationMaker() {
        rat = new Rat(10, 0, "1-3", "Rat");
        spider = new Spider(15, 0, "3-5", "Spider");
        troll = new Troll(25, 0, "7-11", "Troll");
        bear = new Bear(35, 0, "13-20", "Bear");
        orc = new Orc(45, 0, "15-22", "Orc");
        dragon = new Dragon(60, 0, "17-25", "Dragon");
    }

    public void ratInformation() {
        rat.information();
    }

    public void spiderInformation() {
        spider.information();
    }

    public void trollInformation() {
        troll.information();
    }

    public void bearInformation() {
        bear.information();
    }

    public void orcInformation() {
        orc.information();
    }

    public void dragonInformation() {
        dragon.information();
    }
}
