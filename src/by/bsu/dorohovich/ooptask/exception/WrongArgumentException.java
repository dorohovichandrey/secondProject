package by.bsu.dorohovich.ooptask.exception;

/**
 * Created by User on 05.10.2016.
 */
public class WrongArgumentException extends Exception {
    public WrongArgumentException() {
    }

    public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentException(Throwable cause) {
        super(cause);
    }
}
