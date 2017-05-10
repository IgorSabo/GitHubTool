# GitHubTool

User manual

This application is small console connector to GitHub api.<b>

<b>Steps to setup:</b><br>
Generate jar file from the project (rename it to ghtool.jar if needed)<br>
Once jar file is generated to a desired location, additional folder called config needs to be created in the same place where jar file is located, and two property files appConfig.properties and displayParametersConfig.properties, need to be copied there.<br>
These files make our application configuration configurable.<br>
Once done, your structure should look like this:<br>

|--config<br>
|&nbsp;&nbsp;&nbsp;&nbsp;|-- appConfig.properties<br>
|&nbsp;&nbsp;&nbsp;&nbsp;|-- displayParametersConfig.properties<br>
|<br>
|--GitHubTool.jar<br>
<br>
<b>Application configuration:</b><br>
appConfig.properties file contains following properties:

displayJsonOutput - by setting this value to true we are choosing to view our results in json format, by setting it to false however, 
                    our results will be displayed in more user friendly manner
                    
useCustomDisplayConfig - by setting this value to true(displayJsonOutput needs to be false!!!) we can choose what params we want to view. Consult the displayParametersConfig.properties file for a complete list of all available properties. Setting any value from those to true will result in them being displayed on output, setting them to false will not show them. 

defaultResultsNum - Default number of displayed results
maxThreadCount - max number of threads that are available to be executed per one console command.

displayParametersConfig.properties file contains all information parameters that are available for a repository.

<b>Usage examples</b><br>
Application has following commands at users disposal:
Attributes displayed in <> are optional

- list <language> <-n X> This command will return X number of public repositories (and display various attributes regarding them) written in java language. Format response and displayed attributes and are configurable through earlier explained usage of property files.
  example: list java -n 5
- desc <id1 id2 id3...idX> This command will return various information about X number of public repositories. Format response and displayed attributes and are configurable through earlier explained usage of property files. If a user does not provide parameters after desc command, application will display information about desc command usage.
- exit Terminates the application
- reinitialize_configs Command that enables us to update application configuration and display configuration by changing the values from previously mentioned property files. Application restart is not needed is reinitialize_configs command is called after files are saved.
 
 
 

