package dora.db.test.exception;

public class ConstraintException extends RuntimeException {

    public ConstraintException() {
    }

    public ConstraintException(String message) {
        super(message);
    }
}
