package org.tyoda.wurm.customcreatures;

public class MissingPropertyException extends RuntimeException {
    public MissingPropertyException(String message) {
        super(message);
    }

    public MissingPropertyException(Throwable e) {
        super(e);
    }

    public MissingPropertyException(String message, Throwable e) {
        super(message, e);
    }
}
