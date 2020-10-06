package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Rat rat = new Rat(10, 0, "1-3", "Rat");
    Spider spider = new Spider(15, 0, "3-5", "Spider");
    Troll troll = new Troll(25, 0, "7-11", "Troll");
    Bear bear = new Bear(35, 0, "13-20", "Bear");
    Orc orc = new Orc(45, 0, "15-22", "Orc");
    Dragon dragon = new Dragon(60, 0, "17-25", "Dragon");

    Warrior warrior = new Warrior(25, 0, "4-7", "", 1, 50);


    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    private int numOfHealthPotions = 1;
    private int numOfRagePotions = 1;
    private int healAmount = 20;
    private int rageAmount = 25;
    private int healthPotionDropChance= 50;
    private int ragePotionDropChance = 50;
    private ArrayList<Monsters> monsters = new ArrayList<>();
    private int monsterHealth;
    private int monsterDamage;
    private int numberOfCharacters;

    public Game(){

    }

    public void showMainMenu() {
        String menuChoice = "";
        while(!menuChoice.equals("0")) {
            System.out.println("1: Play the game\n" +
                    "2: Create new character\n" +
                    "3: View character\n" +
                    "4: Warrior information\n" +
                    "5: View monsters\n" +
                    "0: Exit");
            System.out.println("Enter your menu choice");

            menuChoice = scan.nextLine();

            switch (menuChoice) {
                case "1":
                    playTheGame();
                    break;

                case "2":
                    createCharacter();
                    break;

                case "3":
                    viewCharacter();
                    break;

                case "4":
                    warriorInformation();
                    break;

                case "5":
                    viewMonsters();
                    break;

                case "0":
                    exit();
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public void playTheGame() {

    }

    public void useHealthPotion() {
        if (numOfHealthPotions == 0) {
            System.out.println("You are out of health potions, kill monsters to get more");
        }
        else if(warrior.health == 25) {
            System.out.println("You already have full health");
        }
        else if(warrior.health + healAmount > 25) {
            warrior.health = 25;
            numOfHealthPotions--;
        }
        else {
            warrior.health += healAmount;
            numOfHealthPotions--;
        }
    }

    public void useRagePotion() {
        if (numOfRagePotions == 0) {
            System.out.println("You are out of rage potions, kill monsters to get more");
        }
        else if(warrior.rage == 50) {
            System.out.println("You already have full rage");
        }
        else if(warrior.rage + rageAmount > 50) {
            warrior.rage = 50;
            numOfRagePotions--;
        }
        else {
            warrior.rage += rageAmount;
            numOfRagePotions--;
        }
    }

    public void dropChanceHealthAndRage() {
        if(rand.nextInt(100) > healthPotionDropChance) {
            numOfHealthPotions++;
            System.out.println("You got a health potion and now have " + numOfHealthPotions + " health potions");
        }
        if(rand.nextInt(100) > ragePotionDropChance) {
            numOfRagePotions++;
            System.out.println("You got a rage potion and now have " + numOfRagePotions + " rage potions");
        }
    }

    public void createCharacter() {
        if(numberOfCharacters == 1) {
            System.out.println("You already have a character");
            showMainMenu();
        } else {
            System.out.println("Enter the name of your character: ");
            warrior.name = scan.nextLine();
            numberOfCharacters++;
            System.out.println("You created a warrior called " + warrior.name);
            showMainMenu();
        }
    }

    public void viewCharacter() {
        if(numberOfCharacters == 0) {
            System.out.println("You need to create a character");
            showMainMenu();
        } else {
            System.out.println(warrior.name + " The mighty warrior");
            System.out.println("Health: " + warrior.health);
            System.out.println("Rage: " + warrior.rage);
            System.out.println("Level: " + warrior.level);
            System.out.println("Health potions: " + numOfHealthPotions);
            System.out.println("Rage potions: " + numOfRagePotions);
        }
    }

    public void warriorInformation() {
        warrior.information();
        showMainMenu();
    }

    public void viewMonsters() {
        monsters.add(rat);
        monsters.add(spider);
        monsters.add(troll);
        monsters.add(bear);
        monsters.add(orc);
        monsters.add(dragon);

        System.out.println("These are all of the different monsters in the game:");
        for(Monsters monster : monsters) {
            System.out.println(monster);
        }
        showMainMenu();
    }

    public void exit() {
        System.out.println("Thanks for playing my game");
        System.exit(0);
    }
}
