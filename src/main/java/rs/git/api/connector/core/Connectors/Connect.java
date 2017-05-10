package rs.git.api.connector.core.Connectors;

import rs.git.api.connector.wrappers.ApiResponseWrapper;

/**
 * Connect interface that declares sendRequest method
 */
public interface Connect {

     ApiResponseWrapper sendRequest(String url);
}
