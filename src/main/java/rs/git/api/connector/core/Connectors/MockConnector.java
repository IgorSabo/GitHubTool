package rs.git.api.connector.core.Connectors;

import rs.git.api.connector.wrappers.ApiResponseWrapper;

import java.io.*;

/**
 * Created by Gile on 5/9/2017.
 */
public class MockConnector implements Connect{


    public ApiResponseWrapper sendRequest(String url)  {
        ApiResponseWrapper wrapper = null;
        String response="";

        if(url.equals("https://api.github.com/search/repositories?q=language:java&per_page=10&sort=created")){
            File testFile = new File("src/test/resources/", "ListResponse.json");
            response = getFileContent(testFile);

        }else if( url.equals("https://api.github.com/repositories/7508411")) {
            File testFile = new File("src/test/resources/", "DescResponse7508411.json");
            response = getFileContent(testFile);

        }else if(url.equals("https://api.github.com/repositories/1663468")){
            File testFile = new File("src/test/resources/", "DescResponse1663468.json");
            response = getFileContent(testFile);
        }

        wrapper = new ApiResponseWrapper(null, response, 202);
        return wrapper;
    }







    public String getFileContent(File f){
        StringBuffer sb = new StringBuffer();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((line=br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
