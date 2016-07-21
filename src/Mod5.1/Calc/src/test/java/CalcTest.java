import api.Calculate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Chucky on 21.07.2016.
 */
public class CalcTest {

    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private Calculate calculate = context.getBean("calculate", Calculate.class);

    @Test
    public void testRun() throws Exception {
        assertEquals("4011.3.21", calculate.execute("+,1994-07-31, 2016-07-21"));
        assertEquals("0.0.4", calculate.execute("-,2016-07-25, 2016-07-21"));
        assertEquals("81", calculate.execute("*,9, 9"));
        assertEquals("-27", calculate.execute("*,3, -9"));
        assertEquals("5", calculate.execute("/,25, 5"));
        assertEquals("7.5", calculate.execute("/,24, 3.2"));
        assertEquals("41", calculate.execute("+,24, 17"));
        assertEquals("26", calculate.execute("+,14, 12"));
        assertEquals("-4.5", calculate.execute("-,7.5, 12"));
        assertEquals("5.5", calculate.execute("-,17.5, 12"));
        assertEquals("5", calculate.execute("sqrt,25"));
        assertEquals("120", calculate.execute("fact,5"));
    }
}