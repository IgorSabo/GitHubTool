package rs.git.api.connector.wrappers;

import rs.git.api.connector.commands.GitCommand;

/**
 * Created by Gile on 5/8/2017.
 */
public class ApiResponseWrapper extends Wrapper {

    public ApiResponseWrapper(GitCommand command, String text, int httpStatusCode){
        this.command = command;
        this.text = text;
        this.httpStatusCode = httpStatusCode;
    }

    private String text;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
