package ua.in.vyshnya;

import org.testng.annotations.Test;
import ua.in.vyshnya.api.Calc;
import ua.in.vyshnya.exceptions.NotFoundModule;
import ua.in.vyshnya.exceptions.NotFoundOperation;
import ua.in.vyshnya.exceptions.NotValidSizeArguments;

import static org.testng.Assert.*;

/**
 * Created by Chucky on 30.07.2016.
 */
public class SuperCalcTest {

    private Calc instance = new SuperCalc();

    @Test
    public void testExecute() throws Exception {
        assertEquals("+, 2, 3 = 5", instance.execute("+, 2, 3"));
        assertEquals("-, 20, 3 = 17", instance.execute("-, 20, 3"));

        assertEquals("*, 20, 3 = 60", instance.execute("*, 20, 3"));
        assertEquals("/, 81, 9 = 9", instance.execute("/, 81, 9"));

        assertEquals("sqrt, 25 = 5", instance.execute("sqrt, 25"));
        assertEquals("fact, 5 = 120", instance.execute("fact, 5"));

    }

    @Test(expectedExceptions = NotValidSizeArguments.class)
    public void testExecuteExceptionNotValidSizeArguments() throws Exception {
        assertEquals("+, 2, 3 = 5", instance.execute("+"));
    }

    @Test(expectedExceptions = NotFoundModule.class)
    public void testExecuteExceptionNotFoundModule() throws Exception {
        instance.execute("+, 5, jkjkjkjk");
    }

    @Test(expectedExceptions = NotFoundOperation.class)
    public void testExecuteExceptionNotFoundOperation() throws Exception {
        instance.execute(":, 5.5, 9.4");
    }

    @Test(expectedExceptions = NotFoundOperation.class)
    public void testExecuteExceptionNotFoundOperation2() throws Exception {
        instance.execute("9.4, 5.5, +");
    }
}