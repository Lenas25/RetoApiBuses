package civa.reto.apiBuses.exception;

public class NotFound  extends RuntimeException {
    private String message;

    public NotFound(String message) {
        super(message);
    }
}
