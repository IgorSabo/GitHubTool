package rs.git.api.tests.parser;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rs.git.api.connector.parser.JsonResponseParser;
import rs.git.api.connector.responses.ApiErrorResponse;
import rs.git.api.connector.responses.ApiRepoResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Gile on 5/9/2017.
 */
public class JsonResponseParserTest {

    private static File listResponse=null;
    private static File descResponse7508411=null;
    private static File notFound=null;

    @BeforeClass
    public static void initializeTestFile(){

        try{
            listResponse = new File("src/test/resources/", "ListResponse.json");
            descResponse7508411 = new File("src/test/resources/", "DescResponse7508411.json");
            notFound = new File("src/test/resources/", "NotFound.json");
        }
        catch(Exception e){
            Assert.fail("Exception occured during initialization method: "+e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Test parsing of list command api response using parseJsonArray method of JsonResponseParser, with given valid json response that contains 10 results
     * Result should be List<ApiRepoResponse>
     */
    @Test
    public void test_01(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(listResponse));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }


            List<ApiRepoResponse> list = JsonResponseParser.parseJsonArray(sb.toString());

            if(list == null)
                Assert.fail("List is null");


            if(list.size() != 10)
                Assert.fail("List does not contain 10 elements!");

            int[] ids = {7508411, 507775, 892275, 5152285, 22790488, 20300177, 8575137, 19148949, 11267509, 2862290};

            //verify if all ids are present in the response
            for(int id : ids){
                boolean found=false;

                for(ApiRepoResponse response : list){
                    if(response.getId() == id){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    Assert.fail("Id "+id+" was not found in the list!");
                }
            }
        }
        catch(Exception e){
            Assert.fail("Exception occured during testing: "+e.getMessage());
        }
    }

    /**
     * Test parsing of desc command api response using parseJsonObject method of JsonResponseParser, with given valid json response that contains 1 result
     * Result should be ApiRepoResponse
     */
    @Test
    public void test_02(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(descResponse7508411));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }
            ApiRepoResponse result = JsonResponseParser.parseJsonObject(sb.toString());

            if(result == null)
                Assert.fail("Object is null");

            if(result.getId() != 7508411)
                Assert.fail("Wrong id, parsing not successfull!");
        }
        catch(Exception e){
            Assert.fail("Exception occured during testing: "+e.getMessage());
        }
    }

    /**
     * Test parsing of a not found response, applicable to other api error codes
     * Result should be ApiErrorResponse
     */
    @Test
    public void test_03(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(notFound));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }

            ApiErrorResponse error = JsonResponseParser.parserError(sb.toString());
            if(error == null)
                Assert.fail("Object is null");

            if(!error.getMessage().equals("Not Found"))
                Assert.fail("Message does not match!");
        }
        catch(Exception e){
            Assert.fail("Exception occured during testing: "+e.getMessage());
        }
    }

}