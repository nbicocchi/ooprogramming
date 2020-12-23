package org.nbicocchi.exceptions.exercises;

public class gException extends Exception {
    private static final long serialVersionUID = 1L;

    public gException() {
        super();
    }

    public gException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public gException(String message, Throwable cause) {
        super(message, cause);
    }

    public gException(String message) {
        super(message);
    }

    public gException(Throwable cause) {
        super(cause);
    }
}
