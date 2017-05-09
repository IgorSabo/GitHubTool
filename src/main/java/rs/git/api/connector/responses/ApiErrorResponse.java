package rs.git.api.connector.responses;

/**
 * Error response returned by github api
 */
public class ApiErrorResponse {

    public ApiErrorResponse(){

    }

    private String message;
    private String documentationUrl;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }
}
