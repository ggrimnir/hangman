package practice.org;

import practice.org.controller.GameProcess;
import practice.org.exception.DictionaryEmptyException;

public class App {
    public static void main(String[] args) {
        try {
            GameProcess gameProcess = new GameProcess();
            gameProcess.execute();
        } catch (DictionaryEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
