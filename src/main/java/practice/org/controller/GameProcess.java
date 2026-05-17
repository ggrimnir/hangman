package practice.org.controller;

import practice.org.view.Console;
import practice.org.exception.ConsoleLetterRequestInputException;
import practice.org.exception.GameLetterInvalidException;
import practice.org.exception.GameLetterUsedException;
import practice.org.model.Game;
import practice.org.model.GameStatus;

public class GameProcess {
    private Game game;
    private final Console console;


    public GameProcess() {
        game = new Game();
        console = new Console();
    }

    public Game getGame() {
        return game;
    }

    public Console getConsole() {
        return console;
    }

    public void execute() {
        switch (console.mainMenuStart()) {
            case 1 -> {
                console.printNewGameMessage();
                startNewGame();
            }
            case 2 -> console.exit();
        }

    }

    private void startNewGame() {
        console.printMask(game.getActualMask());
        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            processOneTurn();
        }
        showFinalResult();
        showReplayRequest();
    }

    private void processOneTurn() {
        try {
            char letter = console.letterRequest();
            game.checkGuess(letter);
            showInfoForValidGuess();
        } catch (GameLetterUsedException | ConsoleLetterRequestInputException e) {
            console.printExceptionMessage(e);
        } catch (GameLetterInvalidException e) {
            console.printExceptionMessage(e);
            showInfoForInvalidGuess();
        }
    }

    private void showInfoForValidGuess() {
        console.printSuccessfulGuessForPlayer(game.getActualMask());
        game.checkGameStatus();
    }

    private void showInfoForInvalidGuess() {
        console.printStatisticsMessageForPlayer(game.getMistakesCount(), game.getMaxMistakesCount());
        console.printHangmanStage(game.getHangmanStage());
        console.printMask(game.getActualMask());
        game.checkGameStatus();
    }

    private void showFinalResult() {
        if (game.getGameStatus() == GameStatus.WON) {
            console.printGameWon();
        } else {
            String wordAsString = game.getWord().toString();
            console.printGameLost(wordAsString);
        }
    }

    private void showReplayRequest() {
        int response = console.replayRequest();
        switch (response) {
            case 1 -> {
                game = new Game();
                startNewGame();
            }
            case 2 -> console.exit();
        }
    }
}
