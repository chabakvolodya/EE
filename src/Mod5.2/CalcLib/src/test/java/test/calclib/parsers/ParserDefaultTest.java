package test.calclib.parsers;

import org.testng.annotations.Test;
import test.calclib.api.Parser;
import test.calclib.exceptions.NotValidSizeArguments;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Chucky on 30.07.2016.
 */
public class ParserDefaultTest {

    Parser instance = new ParserDefault();

    @Test
    public void testParse() throws Exception {
        assertEquals(3, instance.parse("+, 2, 3").size());
    }

    @Test(expectedExceptions = NotValidSizeArguments.class)
    public void testParseNotValidSizeArguments() throws Exception {
        instance.parse("+").size();
    }

}