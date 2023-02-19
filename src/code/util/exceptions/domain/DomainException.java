package code.util.exceptions.domain;

public abstract sealed class DomainException extends RuntimeException permits ParameterNotValidException {
    
    private static final long serialVersionUID = 1L;

    protected DomainException(String message) {
        super(message);
    }

    protected DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DomainException(Throwable cause) {
        super(cause);
    }

}
