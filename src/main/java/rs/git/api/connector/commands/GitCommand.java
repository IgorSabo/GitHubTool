package rs.git.api.connector.commands;

import rs.git.api.connector.AppConstants;

/**
 * Created by Gile on 5/5/2017.
 */
public enum GitCommand {



    LIST("Listing public repositories:",
         "list",
         "{0} <languageType> <resultsNumber> <startPage>",
         "Elements within <> braces are optional.",
         "languageType - desired coding language "+ AppConstants.PARAMS_DESC_SEPARATOR+" resultsNumber - number of results, default 10 "+ AppConstants.PARAMS_DESC_SEPARATOR+" startPage - start our search from the given page",
         "java -jar ghtool.jar list pearl -n10"),

    DESC("Retrieve detail for repository identified by id:",
         "desc",
         "{0} id1, id2, id3, id4 ..., idN",
         "Applicable to multiple repositories",
         "idN - id of a single repository",
         "java -jar ghtool.jar desc 151, 152, 153");











    GitCommand(String commandTitle, String paramValue, String commandFormat, String optionalNote, String optionalParametersDesc, String example){
        this.commandTitle = commandTitle;
        this.paramValue = paramValue;
        this.commandFormat = commandFormat;
        this.optionalNote = optionalNote;
        this.optionalParametersDesc = optionalParametersDesc;
        this.example = example;
    }

    private String commandTitle;
    private String paramValue;
    private String commandFormat;
    private String optionalNote;
    private String optionalParametersDesc;
    private String example;

    public String getCommandTitle() {
        return commandTitle;
    }

    public void setCommandTitle(String commandTitle) {
        this.commandTitle = commandTitle;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getCommandFormat() {
        return commandFormat;
    }

    public void setCommandFormat(String commandFormat) {
        this.commandFormat = commandFormat;
    }

    public String getOptionalNote() {
        return optionalNote;
    }

    public void setOptionalNote(String optionalNote) {
        this.optionalNote = optionalNote;
    }

    public String getOptionalParametersDesc() {
        return optionalParametersDesc;
    }

    public void setOptionalParametersDesc(String optionalParametersDesc) {
        this.optionalParametersDesc = optionalParametersDesc;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
