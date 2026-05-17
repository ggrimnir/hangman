package practice.org.model;

import java.util.*;

public class MaskHandler {
    private final StringBuilder mask;
    private final Map<Character, List<Integer>> lettersIndexes = new HashMap<>();

    public MaskHandler(Word word) {
        mask = initNewGameMask(word);
        extractLettersIndexes(word);
    }

    public StringBuilder getMask() {
        return mask;
    }

    public StringBuilder initNewGameMask(Word word) {
        return new StringBuilder("*".repeat(word.getLength()));
    }

    public StringBuilder openLettersInTheMask(char letter) {
        List<Integer> indexes = lettersIndexes.getOrDefault(letter, Collections.emptyList());
        for (int i : indexes) {
            mask.setCharAt(i, letter);
        }
        return mask;
    }

    public void extractLettersIndexes(Word word) {
        for (int i = 0; i < word.getLength(); i++) {
            char curr = word.getWord().charAt(i);
            int index = i;
            lettersIndexes.compute(curr, (key, val) ->
            {
                if (val == null) {
                    val = new ArrayList<>();
                    val.add(index);
                } else {
                    val.add(index);
                }
                return val;
            });
        }
    }
}
