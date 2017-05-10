package rs.git.api.connector.core.Processors;

import rs.git.api.connector.GitHubApiConnector;
import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.Connectors.Connect;
import rs.git.api.connector.core.Connectors.Connector;
import rs.git.api.connector.core.ThreadStarter;
import rs.git.api.connector.exceptions.BadArgumentsException;
import rs.git.api.connector.loaders.AppConfigLoader;
import rs.git.api.connector.loaders.DisplayConfigLoader;
import rs.git.api.connector.util.Utils;
import rs.git.api.connector.wrappers.UrlsWrapper;

/**
 * Created by Gile on 5/8/2017.
 */
public class InputLineProcessor {

    static ParamProcessor paramProcessor;
    static Connect connector;

    public void processInput(String line) throws BadArgumentsException, InterruptedException {

        paramProcessor = new ParamProcessor();
        connector = new Connector();
        ThreadStarter ts = new ThreadStarter();
        ts.setConnector(connector);

        String[] parts = line.split(" ");

        if(parts[0].equals(GitCommand.LIST.getParamValue())){
           UrlsWrapper wrapper = paramProcessor.processListParams(parts);
           ts.startThreads(wrapper);
        }
        else if(parts[0].equals(GitCommand.DESC.getParamValue())){

            if(parts.length<2){
                Utils.printUsagePerCommand(GitCommand.DESC);
            }
            else{
                UrlsWrapper wrapper = paramProcessor.processDescParams(parts);
                ts.startThreads(wrapper);
            }
        }
        else if(parts[0].toLowerCase().equals("reinitialize_configs")){
            AppConfigLoader.getInstance().reinitializeConfig();
            DisplayConfigLoader.getInstance().reinitializeConfig();
        }
        else if(parts[0].toLowerCase().equals("exit")){
            GitHubApiConnector.running=false;
        }
        else{
            throw new BadArgumentsException("Invalid command!!!");
        }

    }
}
