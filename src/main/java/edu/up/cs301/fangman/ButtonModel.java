package edu.up.cs301.fangman;

public class ButtonModel {

    int numWrongGuesses = 0;
    int numRightGuesses = 0;
    int numFeatures = 7;
    char guessedChar;
    char[] chosenWord;
    int wins = 0;
    int losses = 0;
    boolean ifWon = false;
    boolean inWord;
    boolean isGameOver = false;
}
