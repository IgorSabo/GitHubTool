package rs.git.api.connector.exceptions;

/**
 * Created by Gile on 5/6/2017.
 */
public abstract class GitHubToolException extends Exception {

    private static final long serialVersionUID = 8056164868974316938L;

    public GitHubToolException(){
        super();
    }

    public GitHubToolException(String message, Throwable cause){
        super(message, cause);
    }

    public GitHubToolException(String message){
        super(message);
    }

    public GitHubToolException(Throwable cause){
        super(cause);
    }

}
