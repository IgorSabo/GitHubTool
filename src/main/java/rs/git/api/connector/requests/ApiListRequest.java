package rs.git.api.connector.requests;

import rs.git.api.connector.commands.GitCommand;

/**
 * Created by Gile on 5/6/2017.
 */
public class ApiListRequest extends ApiRequest {

    private int resultsNum;

    private String language=null;

    public ApiListRequest(int resultsNum){
        this.action=GitCommand.LIST;
        this.resultsNum=resultsNum;
    }

    public ApiListRequest(String language, int resultsNum){
        this.action=GitCommand.LIST;
        this.language=language;
        this.resultsNum=resultsNum;
    }


    public int getResultsNum() {
        return resultsNum;
    }

    public void setResultsNum(int resultsNum) {
        this.resultsNum = resultsNum;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
