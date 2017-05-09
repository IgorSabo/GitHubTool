package rs.git.api.connector.requests;

import rs.git.api.connector.commands.GitCommand;

/**
 * Created by Gile on 5/6/2017.
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
