package test.calcspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import test.calclib.api.Calc;
import test.calclib.exceptions.NotFoundModule;
import test.calclib.exceptions.NotFoundOperation;
import test.calclib.exceptions.NotValidSizeArguments;
import test.calcspring.config.AOPConfig;
import test.calcspring.config.AppConfig;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chucky on 30.07.2016.
 */
public class RunnerTest {

    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AOPConfig.class);
    private  Calc calc = context.getBean("lib", Calc.class);

    @Test
    public void testMain() throws Exception {

        assertEquals("+,1994-07-31, 2016-07-21 = 4011.3.21", calc.execute("+,1994-07-31, 2016-07-21"));
        assertEquals("-,2016-07-25, 2016-07-21 = 0.0.-4", calc.execute("-,2016-07-25, 2016-07-21"));
        assertEquals("*,9, 9 = 81", calc.execute("*,9, 9"));
        assertEquals("*,3, -9 = -27", calc.execute("*,3, -9"));
        assertEquals("/,25, 5 = 5", calc.execute("/,25, 5"));
        assertEquals("/,24, 3.2 = 7.5", calc.execute("/,24, 3.2"));
        assertEquals("+,24, 17 = 41", calc.execute("+,24, 17"));
        assertEquals("+,14, 12 = 26", calc.execute("+,14, 12"));
        assertEquals("-,7.5, 12 = -4.5", calc.execute("-,7.5, 12"));
        assertEquals("-,17.5, 12 = 5.5", calc.execute("-,17.5, 12"));
        assertEquals("sqrt,25 = 5", calc.execute("sqrt,25"));
        assertEquals("fact, 5 = 120", calc.execute("fact, 5"));
    }

    @Test(expectedExceptions = NotValidSizeArguments.class)
    public void testExecuteExceptionNotValidSizeArguments() throws Exception {
        assertEquals("+, 2, 3 = 5", calc.execute("+"));
    }

    @Test(expectedExceptions = NotFoundModule.class)
    public void testExecuteExceptionNotFoundModule() throws Exception {
        calc.execute("+, 5, jkjkjkjk");
    }

    @Test(expectedExceptions = NotFoundOperation.class)
    public void testExecuteExceptionNotFoundOperation() throws Exception {
        calc.execute(":, 5.5, 9.4");
    }
}