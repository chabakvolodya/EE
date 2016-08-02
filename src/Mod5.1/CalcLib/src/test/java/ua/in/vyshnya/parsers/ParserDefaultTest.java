package ua.in.vyshnya.parsers;

import org.testng.annotations.Test;
import ua.in.vyshnya.api.Parser;
import ua.in.vyshnya.exceptions.NotValidSizeArguments;

import static org.testng.Assert.*;

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