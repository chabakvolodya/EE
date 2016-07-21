import api.Module;
import api.Operation;
import exeptions.InvalidExpression;
import exeptions.NotFoundModule;
import exeptions.OperationsIsNotCheckedType;
import modules.NumberModule;
import operations.AddNumber;
import operations.SubtractionNumber;
import operations.TestNumber;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Chucky on 19.07.2016.
 */
public class NumberModuleTest {

    private ImplCalculate instance = new ImplCalculate();

    @Test
    public void testExecute() throws Exception {
        assertEquals("7", instance.execute("+, 2, 5"));
        assertEquals("12.3", instance.execute("+, 7.3, 5"));
        assertEquals("2.3", instance.execute("-, 7.3, 5"));
        assertEquals("-3", instance.execute("-, 2, 5"));
    }

    @Test(expectedExceptions = NotFoundModule.class)
    public void testExecuteExceptionNotFoundModule() throws Exception {
        instance.execute(":, 2, 5");
    }

    @Test(expectedExceptions = NotFoundModule.class)
    public void testExecuteExceptionNotFoundModule2() throws Exception {
        instance.execute("+, 2");
    }

    @Test(expectedExceptions = OperationsIsNotCheckedType.class)
    public void testSetOperationException() throws Exception {
        new NumberModule().setOperation("test", new TestNumber());
    }

    @Test
    public void testSetOperationException2() throws Exception {
        new NumberModule().setOperation("-", new SubtractionNumber());
    }

}