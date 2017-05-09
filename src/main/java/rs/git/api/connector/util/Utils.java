package rs.git.api.connector.util;

import com.google.gson.*;
import rs.git.api.connector.AppConstants;
import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.core.StringCreator;
import rs.git.api.connector.responses.ApiErrorResponse;
import rs.git.api.connector.responses.ApiRepoResponse;
import rs.git.api.connector.loaders.AppConfigLoader;
import rs.git.api.connector.parser.JsonResponseParser;
import rs.git.api.connector.wrappers.ApiResponseWrapper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gile on 5/6/2017.
 */
public class Utils {

    public static final String DOUBLE_TAB_INDENT="\t\t";
    public static final String TRIPPLE_TAB_INDENT="\t\t\t";

    private Utils instance;

    private Utils(){
    }

    public synchronized Utils getInstance(){
        if(instance == null){
            instance = new Utils();
        }

        return instance;
    }


    public static void printUsage(){
        int num=0;
        GitCommand[] commands = GitCommand.values();

        System.out.println("******************************* Usage description ********************************");

        //printing command description details
        for(GitCommand command : commands){

            //title
            if(isTextPresent(command.getCommandTitle()))
                System.out.println(++num +") "+command.getCommandTitle());

            //optional note
            if(isTextPresent(command.getOptionalNote()))
                System.out.println(DOUBLE_TAB_INDENT+"Note: "+command.getOptionalNote());

            //format
            if(isTextPresent(command.getCommandFormat()))
                System.out.println(MessageFormat.format(DOUBLE_TAB_INDENT+"Format:\t"+command.getCommandFormat(), command.getParamValue()));

            //param list
            if(isTextPresent(command.getOptionalParametersDesc())){
                System.out.println(DOUBLE_TAB_INDENT+"Params:");

                if(command.getOptionalParametersDesc().contains(AppConstants.PARAMS_DESC_SEPARATOR)){
                    //multiple params present
                    for(String paramDesc : command.getOptionalParametersDesc().split(AppConstants.PARAMS_DESC_SEPARATOR))
                    System.out.println(TRIPPLE_TAB_INDENT+paramDesc.trim());
                }
                else{
                    //single param present
                    System.out.println(TRIPPLE_TAB_INDENT+command.getOptionalParametersDesc());
                }
            }

            //example
            if(isTextPresent(command.getExample())){
                System.out.println(DOUBLE_TAB_INDENT+"Example: "+command.getExample());
            }

            System.out.println("\n");
        }
    }


    public static boolean isTextPresent(String text){
        if(text != null && !text.equals(""))
            return true;
        else
            return false;
    }

    /**
     * Prints response to System.Out
     * @param wrapper
     */
    public static synchronized void printToMainOutput(ApiResponseWrapper wrapper){
        String text = wrapper.getText();
        GitCommand command = wrapper.getCommand();
        if(AppConfigLoader.getInstance().isDisplayJsonOutput()){

            //displayJsonOutput is set to true, so we print the json api output
            System.out.println(toPrettyFormat(text));
        }
        else{

            //checking the status code
            if(wrapper.getHttpStatusCode() == 404 || wrapper.getHttpStatusCode() == 400 || wrapper.getHttpStatusCode() == 401 || wrapper.getHttpStatusCode() == 403 || wrapper.getHttpStatusCode() == 422){
                //error occured

                ApiErrorResponse errorResp = JsonResponseParser.parserError(text);
                System.out.println("Message: "+wrapper.getHttpStatusCode()+", "+errorResp.getMessage());
            }
            else{
                List<ApiRepoResponse> listResponse = new ArrayList<>();

                if(command.equals(GitCommand.LIST)){

                    //parse jsonArray
                    listResponse = JsonResponseParser.parseJsonArray(text);
                }
                else if(command.equals(GitCommand.DESC)){

                    //parse jsonObject
                    listResponse.add(JsonResponseParser.parseJsonObject(text));
                }

                if(AppConfigLoader.getInstance().isUseCustomDisplayConfig()){
                    //select what fields to display
                    System.out.println(StringCreator.createCustomResultString(listResponse, true));
                }
                else{
                    //display all fields
                    System.out.println(StringCreator.createCustomResultString(listResponse, false));
                }
            }


        }
    }


    /**
     * Prints json response in human readable, multi line format
     * @param jsonString - single line json string
     * @return formatted, multi line json string
     */
    public static String toPrettyFormat(String jsonString)
    {
        JsonParser parser = new JsonParser();
        JsonObject jsonObj =  parser.parse(jsonString).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson;

        if(!jsonObj.has("items")){
            //not json array
            JsonObject json = parser.parse(jsonString).getAsJsonObject();
            prettyJson = gson.toJson(json);
        }
        else{
            JsonArray jsonArray = jsonObj.get("items").getAsJsonArray();
            prettyJson = gson.toJson(jsonArray);
        }

        return prettyJson;
    }





}
