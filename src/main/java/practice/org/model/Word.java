package practice.org.model;

import practice.org.util.Chooser;
import practice.org.util.DictionaryChooser;

import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private final Chooser chooser;
    private final String word;
    private final List<Character> letters;
    private final int length;

    public Word() {
        chooser = new DictionaryChooser();
        word = chooser.choose();
        letters = extractAllLetters();
        length = word.length();
    }

    // добавляем гибкость, на случай, если будет другой источник словаря, например
    public Word(Chooser chooser) {
        this.chooser = chooser;
        word = chooser.choose();
        letters = extractAllLetters();
        length = word.length();
    }

    private List<Character> extractAllLetters() {
        return word.chars()
                .mapToObj(l -> (char) l)
                .collect(Collectors.toList());
    }

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public boolean contains(char letter) {
        return letters.contains(letter);
    }

    @Override
    public String toString() {
        return word;
    }
}
