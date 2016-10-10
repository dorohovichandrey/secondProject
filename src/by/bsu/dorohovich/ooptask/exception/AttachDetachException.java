package by.bsu.dorohovich.ooptask.exception;

/**
 * Created by User on 27.09.2016.
 */
public class AttachDetachException extends Exception {
    public AttachDetachException() {
    }

    public AttachDetachException(String message) {
        super(message);
    }

    public AttachDetachException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttachDetachException(Throwable cause) {
        super(cause);
    }
}
