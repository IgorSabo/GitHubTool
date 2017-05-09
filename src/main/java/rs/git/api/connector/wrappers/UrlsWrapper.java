package rs.git.api.connector.wrappers;

import rs.git.api.connector.commands.GitCommand;

import java.util.List;

/**
 * Created by Gile on 5/6/2017.
 */
public class UrlsWrapper extends Wrapper{

    public UrlsWrapper(GitCommand command, String[] urls) {
        this.command = command;
        this.urls = urls;
    }

    private String[] urls;

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
}
