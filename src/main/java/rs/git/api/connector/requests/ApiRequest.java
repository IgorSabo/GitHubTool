package rs.git.api.connector.requests;

import rs.git.api.connector.commands.GitCommand;

/**
 * Abstract request
 */
public abstract class ApiRequest {

    protected GitCommand action;


    public String getAction() {
        return action.getParamValue();
    }

    public void setAction(GitCommand action) {
        this.action = action;
    }
}
