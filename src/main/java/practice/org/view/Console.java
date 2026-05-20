package practice.org.view;

import practice.org.exception.ConsoleLetterRequestInputException;
import practice.org.exception.ConsoleMenuInputException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    private final Scanner scanner;
    private static final int MAIN_MENU_MAX_POINT = 2;
    private static final int MAIN_MENU_MIN_POINT = 1;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public int mainMenuStart() {
        System.out.println("""
                Menu:\s
                1. Start new game\s
                2. Exit\s
                """);
        String input = scanner.nextLine();
        validateMenuPointInput(input);
        return Integer.parseInt(input);
    }

    public void printNewGameMessage() {
        System.out.println("New game started");
    }

    public char letterRequest() {
        System.out.println("Please, enter a letter:");
        String input = scanner.nextLine().toLowerCase();
        validateGameInput(input);
        return input.charAt(0);
    }

    public void exit() {
        System.out.println("Shutting down...");
        scanner.close();
    }

    public int replayRequest() {
        System.out.println("One more game? \n" +
                "1. Yes! \n" +
                "2. No... \n");
        String input = scanner.nextLine();
        validateMenuPointInput(input);
        return Integer.parseInt(input);
    }

    public void printMask(StringBuilder mask) {
        System.out.println("Word: " + mask + "\n____________");
    }

    public void printHangmanStage(String stage) {
        System.out.println(stage);
    }

    public void printStatisticsMessageForPlayer(int count, int max) {
        System.out.printf("Mistakes: %d of %d%n", count, max);
    }

    public void printSuccessfulGuessForPlayer(StringBuilder mask) {
        System.out.println("Correct!");
        printMask(mask);
    }

    public void printUsedLettersMessage(List<Character> usedLetters) {
        System.out.println("Used letters: " + usedLetters);
    }

    public void printGameWon() {
        System.out.println("Congratulations! You win!\n____________");
    }

    public void printGameLost(String word) {
        System.out.printf("""
                Unfortunately, you lose!\
                The word was %s
                ____________
                """, word);
    }

    public void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }

    private void validateMenuPointInput(String input) {
        try {
            int menuPoint = Integer.parseInt(input);
            if (menuPoint > MAIN_MENU_MAX_POINT || menuPoint < MAIN_MENU_MIN_POINT)
                throw new ConsoleMenuInputException("Invalid menu point input: must be chosen number from 1 to 3");
        } catch (NumberFormatException e) {
            throw new ConsoleMenuInputException("Invalid menu point input: must be entered number");
        }
    }

    private void validateGameInput(String input) {
        if (!Pattern.matches("[А-яёЁ]", input)) {
            throw new ConsoleLetterRequestInputException("Invalid letter request input: must be entered one Russian letter only");
        }
    }
}
