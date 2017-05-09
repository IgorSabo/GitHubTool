package rs.git.api.connector.wrappers;

import rs.git.api.connector.commands.GitCommand;

/**
 * Created by Gile on 5/8/2017.
 */
public abstract class Wrapper {

    protected int httpStatusCode;

    protected GitCommand command;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public GitCommand getCommand() {
        return command;
    }

    public void setCommand(GitCommand command) {
        this.command = command;
    }
}
