package rs.git.api.connector.loaders;

import rs.git.api.connector.GitHubApiConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Gile on 5/7/2017.
 */
public class AppConfigLoader {

    private static Properties properties;

    private boolean useCustomDisplayConfig;
    private boolean displayJsonOutput;
    private int defaultResultsNum;
    private int maxThreadCount;

    public boolean isUseCustomDisplayConfig() {
        return useCustomDisplayConfig;
    }

    public boolean isDisplayJsonOutput() {
        return displayJsonOutput;
    }


    public int getDefaultResultsNum() {
        return defaultResultsNum;
    }


    public int getMaxThreadCount() {
        return maxThreadCount;
    }



    private static AppConfigLoader instance;

    private AppConfigLoader(){
        init();
    }

    public static synchronized AppConfigLoader getInstance(){
        if(instance == null){
            instance = new AppConfigLoader();
        }

        return instance;
    }

    private void init() {
        properties = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config/appConfig.properties");
            //input = GitHubApiConnector.class.getClassLoader().getResourceAsStream("appConfig.properties");
            properties.load(input);

            useCustomDisplayConfig = Boolean.parseBoolean(properties.getProperty("useCustomDisplayConfig"));
            displayJsonOutput = Boolean.parseBoolean(properties.getProperty("displayJsonOutput"));
            defaultResultsNum = Integer.valueOf(properties.getProperty("defaultResultsNum"));
            maxThreadCount = Integer.valueOf(properties.getProperty("maxThreadCount"));

            System.out.println("Use custom display properties: "+useCustomDisplayConfig);
            System.out.println("Display output as json: "+displayJsonOutput);
            System.out.println("Default results number: "+defaultResultsNum);
            System.out.println("Max thread count: "+maxThreadCount);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void reinitializeConfig(){
        init();
    }
}
