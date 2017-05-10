package rs.git.api.connector.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import rs.git.api.connector.responses.ApiErrorResponse;
import rs.git.api.connector.responses.ApiRepoResponse;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Class used to parse strings in json format
 */
public class JsonResponseParser {

    /**
     * Method used to parse individual desc api request (returns json representation of a single repository)
     * @param tmp - json representation of a signle repository
     * @return ApiRepoResponse
     */
    public static ApiRepoResponse parseJsonObject(String tmp){
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonObject json = parser.parse(tmp.toString()).getAsJsonObject();

        Type responseType = new TypeToken<ApiRepoResponse>() {}.getType();
        ApiRepoResponse response =  new Gson().fromJson(json, responseType);

        return response;
    }

    /**
     * Method used to parse individual list api request (returns json representation of a multiple repositories)
     * @param tmp - json array representing multiple repositories
     * @return List<ApiRepoResponse>
     */
    public static List<ApiRepoResponse> parseJsonArray(String tmp){
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonObject jsonObj = parser.parse(tmp.toString()).getAsJsonObject();

        JsonArray json = jsonObj.get("items").getAsJsonArray();

        Type listType = new TypeToken<List<ApiRepoResponse>>() {}.getType();
        List<ApiRepoResponse> response =  new Gson().fromJson(json, listType);

        return response;
    }

    /**
     * Method used to parse not found or error response
     * @param tmp - response string
     * @return ApiErrorResponse
     */
    public static ApiErrorResponse parserError(String tmp){
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonObject json= parser.parse(tmp.toString()).getAsJsonObject();

        Type responseType = new TypeToken<ApiErrorResponse>() {}.getType();
        ApiErrorResponse response =  new Gson().fromJson(json, responseType);

        return response;
    }
}
