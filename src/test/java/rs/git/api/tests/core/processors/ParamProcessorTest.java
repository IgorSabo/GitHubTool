package rs.git.api.tests.core.processors;
import org.junit.Assert;
import org.junit.Test;
import rs.git.api.connector.core.Processors.ParamProcessor;
import rs.git.api.connector.exceptions.BadArgumentsException;

/**
 * Created by Gile on 5/9/2017.
 */

public class ParamProcessorTest {

    /**
     * Test the processListParams of ParamProcessor by passing to it various console commands in bad format
     * Test fails if exception is not thrown
     */
    @Test
    public void test_01(){

        String[] commands = {
            "list -n","list java -n","list java -n asdasd","list java 10","list 10","list -gjhgjgj"
        };

        ParamProcessor processor = new ParamProcessor();

        for(String command : commands){

            try{
                String[] parts = command.split(" ");
                processor.processListParams(parts);

                Assert.fail("BadArgumentsException not thrown");
            }
            catch(BadArgumentsException e){

            }
        }

    }

    /**
     * Test the processDescParams of ParamProcessor by passing to it various console commands in bad format
     * Test fails if exception is not thrown
     */
    @Test
    public void test_02(){
        String[] commands = {
                "desc 123 123 1r3", "desc 1a3", "desc -12"
        };
        ParamProcessor processor = new ParamProcessor();
        for(String command : commands){

            try{
                String[] parts = command.split(" ");
                processor.processDescParams(parts);

                Assert.fail("BadArgumentsException not thrown");
            }
            catch(BadArgumentsException e){

            }
        }
    }
}
