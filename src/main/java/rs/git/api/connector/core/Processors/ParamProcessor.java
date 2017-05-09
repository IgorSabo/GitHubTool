package rs.git.api.connector.core.Processors;

import rs.git.api.connector.AppConstants;
import rs.git.api.connector.commands.GitCommand;
import rs.git.api.connector.exceptions.BadArgumentsException;
import rs.git.api.connector.loaders.AppConfigLoader;
import rs.git.api.connector.requests.ApiDescRequest;
import rs.git.api.connector.requests.ApiListRequest;
import rs.git.api.connector.requests.ApiRequest;
import rs.git.api.connector.wrappers.UrlsWrapper;

/**
 * Process parameters of list and desc commands, return wrapped urls and type of command
 */
public class ParamProcessor {

    /**
     * Process and validate parameters and format for list command
     * @param args - input parameters
     * @return - wrapped urls and type of command
     * @throws BadArgumentsException
     */

    public UrlsWrapper processListParams(String[] args) throws BadArgumentsException{
        int numOfParams = args.length;
        UrlsWrapper wrapper = null;
        String language = null;
        int numOfResults = AppConfigLoader.getInstance().getDefaultResultsNum();


        if(numOfParams == 2){
            //one additional parameter provided
            //must be in "list language" format

            //could be a number, if so, throw BadArgumentsException
            try{
                Integer.valueOf(args[1]);
                throw new BadArgumentsException("Invalid arguments!");
            }
            catch(NumberFormatException e){}

            if(args[1].equals("-n") || args[1].contains("-")){
                throw new BadArgumentsException("Results number is not provided!");
            }
            else{
                //coding language provided
                language=args[1];
            }
        }

        if(numOfParams == 3) {
            //two additional parameters provided,
            // must be in "list -n int" format

            String tmp = args[1];

            if(!tmp.equals("-n")){
                //this is not in "list -n int" format, so arguments are not valid
                throw new BadArgumentsException("Invalid arguments!");
            }
            else if(tmp.equals("-n")){

                //trying to convert third parameter to int
                try{
                    numOfResults = Integer.valueOf(args[2]);
                }
                catch(NumberFormatException e){
                    throw new BadArgumentsException("Invalid arguments!");
                }
            }
        }

        if(numOfParams == 4) {
            //three more additional parameters provided,
            // must be in "list language -n int" format

            //checking to see if second element is language
            language=args[1];

            if(language.equals("-n") || language.contains("-"))
                throw new BadArgumentsException("Provided arguments are not in right order!");

            //could be a number, if so, throw BadArgumentsException
            try{
                Integer.valueOf(language);
                throw new BadArgumentsException("Provided arguments are not in right order!");
            }
            catch(NumberFormatException e){}


            //language verified, checking to see if third element is "-n"
            String tmp = args[2];
            if(!tmp.equals("-n")){
                //this is not in "list language -n int" format, so arguments are not valid
                throw new BadArgumentsException("Invalid arguments!");
            }
            else if(tmp.equals("-n")){

                //trying to convert fourth parameter to int
                try{
                    numOfResults = Integer.valueOf(args[3]);
                }
                catch(NumberFormatException e){
                    throw new BadArgumentsException("Invalid arguments!");
                }
            }
        }

        if(numOfParams >4)
            throw new BadArgumentsException("Invalid arguments!");


        //generate url request for github api list action
        wrapper =  generateApiUrl(new ApiListRequest(language, numOfResults));

        return wrapper;
    }


    /**
     * Process and validate parameters and format for desc command
     * @param args - input parameters
     * @return - wrapped urls and type of command
     * @throws BadArgumentsException
     */
    public UrlsWrapper processDescParams(String[] args) throws BadArgumentsException{
        int numOfParams = args.length;
        UrlsWrapper  wrapper = null;

        //array to hold all passed ids
        int[] ids = new int[numOfParams-1];

        if(numOfParams < 2){

            //no repository id provided
            throw new BadArgumentsException("desc command must be followed by at least one repository id");
        }
        else{

            //populate the array
            for(int i=1; i<numOfParams; i++){

                try{
                    if(Integer.valueOf(args[i]) <0)
                        throw new BadArgumentsException("Invalid arguments!");

                    ids[i-1] = Integer.valueOf(args[i]);
                }
                catch(NumberFormatException e){
                    throw new BadArgumentsException("Invalid arguments!");
                }

            }

        }

        wrapper = generateApiUrl(new ApiDescRequest(ids));
        return wrapper;
    }


    /**
     * Generates api url depending on a type of command (list or desc)
     * @param request
     * @return
     */


    private  UrlsWrapper generateApiUrl(ApiRequest request){
        String[] urls = null;

        UrlsWrapper  wrapper = null;

        if(request.getAction().equals(GitCommand.LIST.getParamValue())){
            ApiListRequest apiListRequest = (ApiListRequest) request;

            //construct url


            String url = AppConstants.URL_SEARCH_ENDPOINT + AppConstants.URL_REPOS + (apiListRequest.getLanguage() != null ? AppConstants.URL_QUERY_PARAM_PREFIX + AppConstants.URL_LANGUAGE_PARAM+apiListRequest.getLanguage() : AppConstants.URL_QUERY_PARAM_PREFIX+"in:") +"&"+ AppConstants.URL_PER_PAGE_PARAM + apiListRequest.getResultsNum()+"&"+AppConstants.URL_SORT_PARAM;
            urls = new String[1];
            urls[0]=url;
            wrapper =new UrlsWrapper(GitCommand.LIST, urls);
        }
        else if(request.getAction().equals(GitCommand.DESC.getParamValue())){
            ApiDescRequest apiDescRequest = (ApiDescRequest) request;

            //number of provided ids
            int idNum = apiDescRequest.getIds().length;
            int[] ids = apiDescRequest.getIds();
            urls = new String[idNum];

            //create urls
            for(int i=0; i<idNum; i++)
                urls[i] = AppConstants.URL_DESC_ENDPOINT +"/"+ids[i];

            wrapper =new UrlsWrapper(GitCommand.DESC, urls);
        }

        return wrapper;
    }
}
