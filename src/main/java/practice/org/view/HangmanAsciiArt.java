package practice.org.view;

public class HangmanAsciiArt {
    private static final String[] STAGES = {
            "  +---+\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "     ===",

            "  +---+\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "     ==="
    };

    public static String getStage(int mistakes) {
        return STAGES[mistakes];
    }
}
