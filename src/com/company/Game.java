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

    }

    public void warriorInformation() {

    }

    public void viewMonsters() {

    }

    public void exit() {
    }
}
