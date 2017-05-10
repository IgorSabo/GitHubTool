package rs.git.api.connector.exceptions;

/**
 * Custom exception thrown when command is invalid
 */
public class BadArgumentsException extends GitHubToolException {

    public BadArgumentsException(String message) {
        super(message);
    }

    public BadArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
