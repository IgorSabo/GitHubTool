package rs.git.api.connector.core;

import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.Connectors.Connect;
import rs.git.api.connector.core.Connectors.Connector;
import rs.git.api.connector.util.Utils;
import rs.git.api.connector.wrappers.ApiResponseWrapper;

/**
 * Thread that sends request to api and gets a string response
 */
public class ApiProcessorJob extends Thread {

    private String url;

    private GitCommand command;

    private Connect connector;

    public ApiProcessorJob(String url, GitCommand command, Connect connector){
        this.url = url;
        this.command = command;
        this.connector = connector;
    }

    @Override
    public void run(){

        try{
            System.out.println("Starting thread for url: "+url);
            ApiResponseWrapper resp = connector.sendRequest(url);
            resp.setCommand(command);
            System.out.println("Thread finished");

            //write to main output
            Utils.printToMainOutput(resp);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void printOutput(ApiResponseWrapper wrapper){
        Utils.printToMainOutput(wrapper);
    }
}
