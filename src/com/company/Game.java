package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    MonsterInformationMaker monsterInformationMaker = new MonsterInformationMaker();
    GameInformationMaker gameInformationMaker = new GameInformationMaker();

    Rat rat = new Rat(10, 0, "1-3", "Rat");
    Spider spider = new Spider(15, 0, "3-5", "Spider");
    Troll troll = new Troll(25, 0, "7-11", "Troll");
    Bear bear = new Bear(35, 0, "13-20", "Bear");
    Orc orc = new Orc(45, 0, "15-22", "Orc");
    Dragon dragon = new Dragon(60, 0, "17-25", "Dragon");

    Warrior warrior = Warrior.getInstance();

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    private int numOfHealthPotions = 1;
    private int numOfRagePotions = 1;
    private int healAmount = 20;
    private int rageAmount = 25;
    private int healthPotionDropChance= 50;
    private int ragePotionDropChance = 50;
    private ArrayList<Monsters> monsters = new ArrayList<>();
    private String monsterName;
    private String monsterDamageInfo;
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
                    "6: Game information\n" +
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

                case "6":
                    gameInformation();
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
        if(numberOfCharacters == 0) {
            System.out.println("You need to create a character first");
            showMainMenu();
        }

        while(rat.health > 0 && warrior.health > 0 && warrior.level < 2.5) {
            System.out.println("Health: " + warrior.health + "          " + "Enemy health: " + rat.health + "\n" +
                    "Rage: " + warrior.rage + "            " + "Enemy damage: " + rat.damageInfo + "\n" +
                    "Health potions: " + numOfHealthPotions + "\n" +
                    "Rage potions: " + numOfRagePotions + "\n");
            rat.makeNoise();
            System.out.println("You are fighting a rat\n" +
                    "1: Attack\n" +
                    "2: Whirlwind\n" +
                    "3: Use health potion\n" +
                    "4: use rage potion\n" +
                    "0: Leave dungeon");
            try {
                String userInput = scan.nextLine();
                int warriorDamage = warrior.getDamage();
                int ratDamage = rat.getRatDamage();

                switch(userInput) {
                    case "1":
                        rat.health -= warriorDamage;
                        warrior.health -= ratDamage;

                        System.out.println("You attack the rat for " + warriorDamage + " damage");
                        System.out.println("The rat attacks you for " + ratDamage + " damage");

                        if(warrior.health <= 0) {
                            System.out.println("You lost the fight and your character is dead");
                            numberOfCharacters--;
                            showMainMenu();
                        } else if (rat.health <= 0) {
                            System.out.println("You won the fight");
                            warrior.level += 0.5;
                            System.out.println("Your level is now " + warrior.level + " and your strength is growing");
                            rat.health = 10;
                            dropChanceHealthAndRage();
                        }
                        break;

                    case "2":
                        if(warrior.rage < 25) {
                            System.out.println("You don't have enough rage");
                        } else {
                            int whirlwind = rand.nextInt(20 - 15 + 1) + 15;
                            warrior.rage -= 25;

                            rat.health -= whirlwind;
                            warrior.health -= ratDamage;

                            System.out.println("You attack the rat for " + whirlwind + " damage");
                            System.out.println("The rat attacks you for " + ratDamage + " damage");

                            if(warrior.health <= 0) {
                                System.out.println("You lost the fight and your character is dead");
                                numberOfCharacters--;
                                showMainMenu();
                            } else if (rat.health <= 0) {
                                System.out.println("You won the fight");
                                warrior.level += 0.5;
                                System.out.println("Your level is now " + warrior.level + " and your strength is growing");
                                rat.health = 10;
                                dropChanceHealthAndRage();
                            }
                        }
                        break;

                    case "3":
                        useHealthPotion();
                        break;

                    case "4":
                        useRagePotion();
                        break;

                    case "0":
                        System.out.println("You manage to escape the dungeon");
                        showMainMenu();
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }

        getRandomMonster();
        while(monsterHealth > 0 && warrior.health > 0 && warrior.level >= 2.5 && warrior.level <= 5) {
            System.out.println("Health: " + warrior.health + "          " + "Enemy health: " + monsterHealth + "\n" +
                    "Rage: " + warrior.rage + "            " + "Enemy damage: " + monsterDamageInfo + "\n" +
                    "Health potions: " + numOfHealthPotions + "\n" +
                    "Rage potions: " + numOfRagePotions + "\n");
            checkMonsterName();
            System.out.println("You are fighting a " + monsterName + "\n" +
                    "1: Attack\n" +
                    "2: Whirlwind\n" +
                    "3: Use health potion\n" +
                    "4: use rage potion\n" +
                    "0: Leave dungeon");
            try {
                String userInput = scan.nextLine();
                int warriorDamage = warrior.getStrongerDamage();

                switch(userInput) {
                    case "1":
                        monsterHealth -= warriorDamage;
                        warrior.health -= monsterDamage;

                        System.out.println("You attack the " + monsterName + " for " + warriorDamage + " damage");
                        System.out.println("The " + monsterName + " attacks you for " + monsterDamage + " damage");

                        if(warrior.health <= 0) {
                            System.out.println("You lost the fight and your character is dead");
                            numberOfCharacters--;
                            showMainMenu();
                        } else if (monsterHealth <= 0) {
                            System.out.println("You won the fight");
                            warrior.level += 0.5;
                            System.out.println("Your level is now " + warrior.level + " and your strength is growing");
                            getRandomMonster();
                            dropChanceHealthAndRage();
                        }
                        break;

                    case "2":
                        if(warrior.rage < 25) {
                            System.out.println("You don't have enough rage");
                        } else {
                            int whirlwind = rand.nextInt(25 - 20 + 1) + 20;
                            warrior.rage -= 25;

                            monsterHealth -= whirlwind;
                            warrior.health -= monsterDamage;

                            System.out.println("You attack the " + monsterName + " for " + whirlwind + " damage");
                            System.out.println("The " + monsterName + " attacks you for " + monsterDamage + " damage");

                            if(warrior.health <= 0) {
                                System.out.println("You lost the fight and your character is dead");
                                numberOfCharacters--;
                                showMainMenu();
                            } else if (monsterHealth <= 0) {
                                System.out.println("You won the fight");
                                warrior.level += 0.5;
                                System.out.println("Your level is now " + warrior.level + " and your strength is growing");
                                getRandomMonster();
                                dropChanceHealthAndRage();
                            }
                        }
                        break;

                    case "3":
                        useHealthPotion();
                        break;

                    case "4":
                        useRagePotion();
                        break;

                    case "0":
                        System.out.println("You manage to escape");
                        showMainMenu();
                        break;

                    default:
                        System.out.println("Wrong input");
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
            if(warrior.level == 5) {
                System.out.println("You won the game!");
                showMainMenu();
            }
        }
    }

    public void useHealthPotion() {
        if (numOfHealthPotions == 0) {
            System.out.println("You are out of health potions, kill monsters to get more");
        }
        else if(warrior.health == 25) {
            System.out.println("You already have full health");
        }
        else if(warrior.health + healAmount > 25) {
            System.out.println("You use a health potion\n");
            warrior.health = 25;
            numOfHealthPotions--;
        }
        else {
            warrior.health += healAmount;
            System.out.println("You use a health potion\n");
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
            System.out.println("You use a rage potion\n");
            warrior.rage = 50;
            numOfRagePotions--;
        }
        else {
            System.out.println("You use a rage potion\n");
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

    public void checkMonsterName() {
        if( monsterName.equalsIgnoreCase("spider")) {
            spider.makeNoise();
        }
        else if( monsterName.equalsIgnoreCase("troll")) {
            troll.makeNoise();
        }
        else if( monsterName.equalsIgnoreCase("bear")) {
            bear.makeNoise();
        }
        else if( monsterName.equalsIgnoreCase("orc")) {
            orc.makeNoise();
        }
        else if( monsterName.equalsIgnoreCase("dragon")) {
            dragon.makeNoise();
        }

    }

    public void getRandomMonster() {
        int randomNumber= rand.nextInt(70) + 1;
        if(randomNumber <= 20) {
            monsterHealth = spider.health;
            monsterName = spider.name;
            monsterDamageInfo = spider.damageInfo;
            monsterDamage = spider.getSpiderDamage();
        }
        if(randomNumber > 20 && randomNumber <= 40) {
            monsterHealth = troll.health;
            monsterName = troll.name;
            monsterDamageInfo = troll.damageInfo;
            monsterDamage = troll.getTrollDamage();
        }
        if(randomNumber > 40 && randomNumber <= 60) {
            monsterHealth = bear.health;
            monsterName = bear.name;
            monsterDamageInfo = bear.damageInfo;
            monsterDamage = bear.getBearDamage();
        }
        if(randomNumber > 60 && randomNumber <= 65) {
            monsterHealth = orc.health;
            monsterName = orc.name;
            monsterDamageInfo = orc.damageInfo;
            monsterDamage = orc.getOrcDamage();
        }
        if(randomNumber > 65) {
            monsterHealth = dragon.health;
            monsterName = dragon.name;
            monsterDamageInfo = dragon.damageInfo;
            monsterDamage = dragon.getDragonDamage();
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
        if(warrior.level >= 2.5) {
            warrior.visitor((Character::setDamageInfo));
            System.out.println(warrior.warriorInformation());
            showMainMenu();
        }
        else {
            System.out.println(warrior.warriorInformation());
            showMainMenu();
        }
    }

    public void viewMonsters() {

        System.out.println("These are all of the different monsters in the game:");
        monsterInformationMaker.ratInformation();
        monsterInformationMaker.spiderInformation();
        monsterInformationMaker.trollInformation();
        monsterInformationMaker.bearInformation();
        monsterInformationMaker.orcInformation();
        monsterInformationMaker.dragonInformation();
        showMainMenu();
    }

    public void gameInformation() {
        gameInformationMaker.displayCharacterInformation();
        gameInformationMaker.displayLevelOneInformation();
        gameInformationMaker.displayLevelTwoInformation();
    }

    public void exit() {
        System.out.println("Thanks for playing my game");
        System.exit(0);
    }
}
