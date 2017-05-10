package rs.git.api.connector.core;

import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.Connectors.Connect;
import rs.git.api.connector.core.Connectors.Connector;
import rs.git.api.connector.loaders.AppConfigLoader;
import rs.git.api.connector.wrappers.UrlsWrapper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class used to start as many threads (but no higher then max default number) as there are urls
 */
public class ThreadStarter {

    private Connect connector;
    private ExecutorService executor = null;
    private ApiProcessorJob processorJob = null;


    public ThreadStarter(){}

    public void setConnector(Connect connector){
        this.connector = connector;
    }

    /**
     * Start threads, one thread per url
     * @param wrapper - UrlsWrapper object, contains array of urls and selected GitCommand type
     * @throws InterruptedException
     */
    public void startThreads(UrlsWrapper wrapper) throws InterruptedException {


            String[] urls = wrapper.getUrls();

            if(wrapper.getCommand().equals(GitCommand.LIST)){

                //start single thread, since list command only has one url per request
                processorJob = new ApiProcessorJob(urls[0], GitCommand.LIST, connector);
                executor = Executors.newFixedThreadPool(1);
                submitJob();

            }
            else if (wrapper.getCommand().equals(GitCommand.DESC)){

                //start multiple threads, but not higher then max default number
                AppConfigLoader appConfig = AppConfigLoader.getInstance();
                int maxThreadCount = (appConfig.getMaxThreadCount() < urls.length) ? appConfig.getMaxThreadCount() : urls.length;

                //initiate the executor with amount of threads
                executor = Executors.newFixedThreadPool(maxThreadCount);
                for(int i=0; i<urls.length; i++){

                    //start as many available threads
                    processorJob = new ApiProcessorJob(urls[i], GitCommand.DESC, connector);
                    submitJob();
                }
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.DAYS);

    }

    public void submitJob(){
        executor.submit(processorJob);
    }
}
