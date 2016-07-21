package parsers;

import api.Parser;
import exeptions.InvalidExpression;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Chucky on 21.07.2016.
 */
public class DefaultParserTest {
    private Map<String, String> map = new HashMap<>();
    private Parser parser = new DefaultParser();

    @BeforeMethod
    private void initMap() {
        map.put("operation", "+");
        map.put("right", "5.2");
        map.put("left", "2");
    }

    @Test
    public void testParse() throws Exception {
        assertEquals(map, parser.parse("+, 2, 5.2"));
    }

    @Test(expectedExceptions = InvalidExpression.class )
    public void testParseExceptionInvalidExpression() throws Exception {
        parser.parse("+");
    }

    @Test(expectedExceptions = InvalidExpression.class )
    public void testParseExceptionInvalidExpression2() throws Exception {
        parser.parse("+, 2, 5.2, 78");
    }

}