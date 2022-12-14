package exceptions;

public class AddAdminException extends RuntimeException{

    public AddAdminException() {
        super();
    }

    public AddAdminException(String message) {
        super(message);
    }

    public AddAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddAdminException(Throwable cause) {
        super(cause);
    }

    protected AddAdminException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
