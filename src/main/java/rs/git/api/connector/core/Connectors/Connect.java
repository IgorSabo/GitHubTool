package rs.git.api.connector.core.Connectors;

import rs.git.api.connector.wrappers.ApiResponseWrapper;

/**
 * Created by Gile on 5/9/2017.
 */
public interface Connect {

     ApiResponseWrapper sendRequest(String url);
}
