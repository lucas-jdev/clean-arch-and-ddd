package code.util.exceptions.domain;

public final class ParameterNotValidException extends DomainException {

    private static final String DEFAULT_MESSAGE = "The parameter is null";

    public ParameterNotValidException() {
        super(DEFAULT_MESSAGE);
    }

    public ParameterNotValidException(String message) {
        super(message);
    }
    
}
