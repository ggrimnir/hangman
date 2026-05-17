package practice.org.exception;

public class DictionaryEmptyException extends RuntimeException {
    public DictionaryEmptyException(String message) {
        super(message);
    }
}
