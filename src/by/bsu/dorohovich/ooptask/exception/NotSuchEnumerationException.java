package by.bsu.dorohovich.ooptask.exception;

/**
 * Created by User on 09.10.2016.
 */
public class NotSuchEnumerationException extends Exception {
    public NotSuchEnumerationException() {
    }

    public NotSuchEnumerationException(String message) {
        super(message);
    }

    public NotSuchEnumerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSuchEnumerationException(Throwable cause) {
        super(cause);
    }
}
