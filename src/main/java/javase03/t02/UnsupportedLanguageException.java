package javase03.t02;

@SuppressWarnings("WeakerAccess")
public class UnsupportedLanguageException extends RuntimeException {

    UnsupportedLanguageException(String message) {
        super(message);
    }
}
