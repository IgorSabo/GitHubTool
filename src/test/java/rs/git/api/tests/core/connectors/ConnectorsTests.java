package rs.git.api.tests.core.connectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;
import rs.git.api.connector.GitHubApiConnector;
import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.Connectors.Connect;
import rs.git.api.connector.core.Connectors.MockConnector;
import rs.git.api.connector.core.ThreadStarter;
import rs.git.api.connector.parser.JsonResponseParser;
import rs.git.api.connector.responses.ApiRepoResponse;
import rs.git.api.connector.util.Utils;
import rs.git.api.connector.wrappers.ApiResponseWrapper;
import rs.git.api.connector.wrappers.UrlsWrapper;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by Gile on 5/9/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConnectorsTests {



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

    /**
     * Send a request to an url generated using 'list java -n 10' command
     */
    @Test
    public void test_01(){
        Connect mockConnector = new MockConnector();
        String[] urls = {listUrl};


        try{
            ApiResponseWrapper wrapper = mockConnector.sendRequest(urls[0]);

            Assert.assertEquals(200, wrapper.getHttpStatusCode());

            List<ApiRepoResponse> list = JsonResponseParser.parseJsonArray(wrapper.getText());

            Assert.assertEquals(10, list.size());

        }
        catch(Exception e){
            Assert.fail("Exception occured: "+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Send a request to an url generated using 'desc 7508411 1663468' command
     */
    @Test
    public void test_02(){
        Connect mockConnector = new MockConnector();
        String[] urls = {descUrlForId7508411, descUrlForId1663468};
        ApiResponseWrapper wrapper = null;

        try{

            for(String url : urls){

                wrapper = mockConnector.sendRequest(url);

                Assert.assertEquals(200, wrapper.getHttpStatusCode());

                ApiRepoResponse obj = JsonResponseParser.parseJsonObject(wrapper.getText());

                int length1 = "https://api.github.com/repositories/".length();

                Long passedId = Long.valueOf(url.substring(length1, url.length()));

                Assert.assertEquals(passedId, obj.getId());
            }

        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail("Exception occured: "+e.getMessage());
            e.printStackTrace();
        }
    }

}
