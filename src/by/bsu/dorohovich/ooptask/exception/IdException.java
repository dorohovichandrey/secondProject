package by.bsu.dorohovich.ooptask.exception;

/**
 * Created by User on 27.09.2016.
 */
public class IdException extends Exception {
    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }

    public IdException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdException(Throwable cause) {
        super(cause);
    }
}
