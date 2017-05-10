package rs.git.api.connector.requests;

import rs.git.api.connector.commands.GitCommand;

/**
 * Request that is generated for desc command
 */
public class ApiDescRequest extends ApiRequest {

    int[] ids;

    public ApiDescRequest(int[] ids){
        this.action = GitCommand.DESC;
        this.ids = ids;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
