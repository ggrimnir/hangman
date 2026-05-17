package practice.org.exception;

public class GameLetterUsedException extends RuntimeException {
    public GameLetterUsedException(String message) {
        super(message);
    }
}
