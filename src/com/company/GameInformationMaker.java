package com.company;

public class GameInformationMaker {

    private GameInformation characterInformation;
    private GameInformation levelOneInformation;
    private GameInformation levelTwoInformation;

    public GameInformationMaker() {
        characterInformation = new CharacterInformation();
        levelOneInformation = new LevelOneInformation();
        levelTwoInformation = new LevelTwoInformation();
    }

    public void displayCharacterInformation() {
        characterInformation.gameInfo();
    }

    public void displayLevelOneInformation() {
        levelOneInformation.gameInfo();
    }

    public void displayLevelTwoInformation() {
        levelTwoInformation.gameInfo();
    }
}
