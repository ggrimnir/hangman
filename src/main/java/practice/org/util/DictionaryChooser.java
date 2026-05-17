package practice.org.util;

import practice.org.exception.DictionaryEmptyException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;


public class DictionaryChooser implements Chooser {
    private static final Path PATH = Path.of("src/main/resources/dictionary");

    public String choose() {
        String chosenWord;
        try {
            List<String> dictionaryList = Files.readAllLines(PATH).stream().filter(word -> word.length() > 5).toList();
            int randomWordId = getRandomNum(dictionaryList.size());
            chosenWord = dictionaryList.get(randomWordId).toLowerCase();
        } catch (IOException | IllegalArgumentException e) {
            throw new DictionaryEmptyException("Fatal error: dictionary not found or empty! \n" +
                    "Check file src/main/resources/dictionary: it must exist and contain words longer than 5 letters");
        }
        return chosenWord;
    }

    private int getRandomNum(int border) {
        Random random = new Random();
        return random.nextInt(border);
    }
}
