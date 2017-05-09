package rs.git.api.connector.exceptions;

/**
 * Created by Gile on 5/6/2017.
 */
public class BadArgumentsException extends GitHubToolException {

    public BadArgumentsException(String message) {
        super(message);
    }

    public BadArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
