package rs.git.api.tests;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rs.git.api.connector.responses.ApiRepoResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gile on 5/6/2017.
 */
public class JsonParserTest {

    private static File testFile=null;

    @BeforeClass
    public static void initializeTestFile(){

        try{
            //testFile = new File("src/test/resources/", "ResponseSample.json");
            //testFile = new File("src/test/resources/", "Python5ResultsResponse.json");
            testFile = new File("src/test/resources/", "DescResponse7508411.json");
        }
        catch(Exception e){
            Assert.fail("Exception occured during initialization method: "+e.getMessage());
            e.printStackTrace();
        }

    }

    //@Test
    public void testPrintJson() {
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader br = new BufferedReader(new FileReader(testFile));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }

            /*String json = gson.toJson(sb.toString());*/
            System.out.println(toPrettyFormat(sb.toString()));

        }
        catch(IOException e){
            Assert.fail("Exception occured during test_01: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testDeserialization(){

        try{

            BufferedReader br = new BufferedReader(new FileReader(testFile));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line=br.readLine()) != null){
                sb.append(line);
            }

            JsonParser parser = new JsonParser();
            //JsonArray json = parser.parse(sb.toString()).getAsJsonArray();
            JsonObject json = parser.parse(sb.toString()).getAsJsonObject();

            Type listType = new TypeToken<ApiRepoResponse>() {}.getType();
            //List<ApiRepoResponse> list = new Gson().fromJson(json, listType);
            ApiRepoResponse list = new Gson().fromJson(json, listType);

            System.out.println("Done");

            //assertEquals(5, list.size());

            /*for(ApiRepoResponse resp : list){

                assertEquals("Language not Python!","Python",resp.getLanguage());
            }*/

        }
        catch(Exception e){
            Assert.fail("Exception occured during deserialization testing: "+e.getMessage());
            e.printStackTrace();
        }



    }

    public static String toPrettyFormat(String jsonString)
    {
        JsonParser parser = new JsonParser();
        JsonArray json = parser.parse(jsonString).getAsJsonArray();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

}
