package com.company;

public class CharacterInformation implements GameInformation {

    @Override
    public void gameInfo(){
        System.out.println("You play as a warrior and your mission is to kill all the monsters in the dungeon.\n" +
                "You start out at level 1 and you gain 0.5 levels every time you kill an enemy.\n" +
                "Pro tip: Every time you kill a monster it has a 50% chance to drop a health potion and or rage potion.\n" +
                "A health potion heals for 20 and a rage potions refills your rage by 25");
    }
}
