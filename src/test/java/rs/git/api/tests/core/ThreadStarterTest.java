package rs.git.api.tests.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import rs.git.api.connector.GitHubApiConnector;
import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.Connectors.Connect;
import rs.git.api.connector.core.Connectors.Connector;
import rs.git.api.connector.core.Connectors.MockConnector;
import rs.git.api.connector.core.ThreadStarter;
import rs.git.api.connector.wrappers.UrlsWrapper;

import java.io.InputStream;
import java.util.Properties;

import static org.mockito.Mockito.*;
import static rs.git.api.connector.commands.GitCommand.DESC;


@RunWith(MockitoJUnitRunner.class)
public class ThreadStarterTest {

    String listUrl=null;
    String descUrlForId7508411=null;
    String descUrlForId1663468=null;


    @Before
    public void init(){
        Properties properties = new Properties();
        InputStream input = null;

        try{
            input = GitHubApiConnector.class.getClassLoader().getResourceAsStream("testConfig.properties");
            properties.load(input);
            listUrl = properties.getProperty("listUrl");
            descUrlForId7508411 = properties.getProperty("descUrl7508411");
            descUrlForId1663468 = properties.getProperty("descUrl1663468");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    /**
     * Testing the scenario where one repository id (7508411) was passed to desc command
     */
    public void test_01(){

        Connect mockConnector = new MockConnector();
        ThreadStarter ts = spy(ThreadStarter.class);

        String[] urls = {descUrlForId7508411};
        UrlsWrapper wrapper = new UrlsWrapper(GitCommand.DESC, urls);

        try{
            ts.setConnector(mockConnector);
            ts.startThreads(wrapper);
            verify(ts).submitJob();
        }
        catch(Exception e){
            Assert.fail("Exception occured: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * Testing the scenario where 2 repository id (7508411, 1663468) were passed to desc command
     */
    public void test_02(){

        Connect mockConnector = new MockConnector();
        ThreadStarter ts = spy(ThreadStarter.class);

        String[] urls = {descUrlForId7508411,descUrlForId1663468};
        UrlsWrapper wrapper = new UrlsWrapper(GitCommand.DESC, urls);

        try{
            ts.setConnector(mockConnector);
            ts.startThreads(wrapper);
            verify(ts, times(2)).submitJob();
        }
        catch(Exception e){
            Assert.fail("Exception occured: "+e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    /**
     * Testing the scenario where user entered list java -n 10
     */
    public void test_03(){

        Connect mockConnector = new MockConnector();
        ThreadStarter ts = spy(ThreadStarter.class);

        String[] urls = {listUrl};
        UrlsWrapper wrapper = new UrlsWrapper(GitCommand.LIST, urls);

        try{
            ts.setConnector(mockConnector);
            ts.startThreads(wrapper);
            verify(ts, times(1)).submitJob();
        }
        catch(Exception e){
            Assert.fail("Exception occured: "+e.getMessage());
            e.printStackTrace();
        }
    }



}
