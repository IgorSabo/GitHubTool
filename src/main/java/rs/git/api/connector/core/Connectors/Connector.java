package rs.git.api.connector.core.Connectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import rs.git.api.connector.wrappers.ApiResponseWrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Send request to and get a response from github api
 */
public class Connector implements Connect {


    HttpClient httpClient;

    private final Logger log = Logger.getLogger(this.getClass());

    public ApiResponseWrapper sendRequest(String url){
        ApiResponseWrapper wrapper = null;
        String response="";
        try{
            HttpGet httpget = new HttpGet(url);
            httpClient = HttpClientBuilder.create().build();

            //submiting get request
            HttpResponse res = httpClient.execute(httpget);

            int statusCode = res.getStatusLine().getStatusCode();

            //reading response body and converting to string
            BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");
            }
            response = result.toString();

            //creating response wrapper
            wrapper = new ApiResponseWrapper(null, response, statusCode);
        }
        catch(Exception e){
            System.out.println("Exception occured during send/receive request to github api: "+e.getMessage());        }

        return wrapper;
    }
}
