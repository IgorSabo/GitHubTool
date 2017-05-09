package rs.git.api.connector;

import rs.git.api.connector.core.Processors.InputLineProcessor;
import rs.git.api.connector.exceptions.GitHubToolException;
import rs.git.api.connector.loaders.AppConfigLoader;
import rs.git.api.connector.loaders.DisplayConfigLoader;
import rs.git.api.connector.util.Utils;

import java.util.Scanner;

/**
 * Created by Gile on 5/5/2017.
 */
public class GitHubApiConnector {

    private static AppConfigLoader appConfig;
    private static DisplayConfigLoader appDisplayConfig;

    public static boolean running=true;

    public static void main(String[] args){

        //initialize app config
        initializeAppConfig();

        //initialize display config
        initializeDisplayConfig();

        InputLineProcessor processor = new InputLineProcessor();

        while(running){
            try{

                System.out.println("Enter command:");
                Scanner in = new Scanner(System.in);


                String line = in.nextLine();

                if(line == null || line.equals("")){
                    Utils.printUsage();
                }
                else{
                    processor.processInput(line);
                }

            }
            catch(InterruptedException e1){
                System.out.println(e1.getMessage());
            }
            catch(GitHubToolException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Application terminated.");

    }

    private static void initializeAppConfig() {
        appConfig = AppConfigLoader.getInstance();
    }

    private static void initializeDisplayConfig() {
        appDisplayConfig = DisplayConfigLoader.getInstance();
    }
}
