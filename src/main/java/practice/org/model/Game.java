package practice.org.model;

import practice.org.view.HangmanAsciiArt;
import practice.org.exception.GameLetterInvalidException;
import practice.org.exception.GameLetterUsedException;

import java.util.*;

public class Game {
    private static final int MAX_MISTAKES_COUNT = 6;
    private final Word word;
    private int mistakesCount;
    private final MaskHandler maskHandler;
    private StringBuilder actualMask;
    private final List<Character> usedLetters;
    private GameStatus gameStatus;

    public Game() {
        word = new Word();
        mistakesCount = 0;
        maskHandler = new MaskHandler(word);
        actualMask = maskHandler.getMask();
        usedLetters = new ArrayList<>();
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public void checkGameStatus() {
        if (actualMask.indexOf("*") == -1) {
            changeGameStatusToWon();
        } else if (getMistakesCount() == MAX_MISTAKES_COUNT) {
            changeGameStatusToLost();
        }
    }

    public void checkGuess(char letter) {
        if (isLetterUsed(letter)) {
            throw new GameLetterUsedException("Letter used already");
        }
        if (!isLetterValid(letter)) {
            increaseMistakesCount();
            addToUsedLetters(letter);
            throw new GameLetterInvalidException("Invalid letter used");
        }
        actualMask = maskHandler.openLettersInTheMask(letter);
        addToUsedLetters(letter);
    }

    public String getHangmanStage() {
        return HangmanAsciiArt.getStage(mistakesCount);
    }

    public Word getWord() {
        return word;
    }

    public int getMistakesCount() {
        return mistakesCount;
    }

    public List<Character> getUsedLetters() {
        return Collections.unmodifiableList(usedLetters);
    }

    public StringBuilder getActualMask() {
        return actualMask;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getMaxMistakesCount() {
        return MAX_MISTAKES_COUNT;
    }

    private void addToUsedLetters(char letter) {
        usedLetters.add(letter);
    }

    private boolean isLetterUsed(char letter) {
        return usedLetters.contains(letter);
    }

    private boolean isLetterValid(char letter) {
        return word.contains(letter);
    }

    private void increaseMistakesCount() {
        mistakesCount += 1;
    }

    private void changeGameStatusToLost() {
        gameStatus = GameStatus.LOST;
    }

    private void changeGameStatusToWon() {
        gameStatus = GameStatus.WON;
    }
}
