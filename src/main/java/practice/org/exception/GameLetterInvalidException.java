package practice.org.exception;

public class GameLetterInvalidException extends RuntimeException {
    public GameLetterInvalidException(String message) {
        super(message);
    }
}
