package test.calclib.parsers;

import test.calclib.api.Parser;
import test.calclib.exceptions.NotValidSizeArguments;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chucky on 20.07.2016.
 */
public class ParserDefault implements Parser {

    @Override
    public Map<String, Object> parse(String expression) {

        Map<String, Object> result = new HashMap<>();
        expression = expression.replaceAll("\\s", "");
        String array[] = expression.split(",");
        if (array.length == 2) {

            result.put("operation", array[0]);
            result.put("right", array[1]);
        } else if (array.length == 3) {

            result.put("operation", array[0]);
            result.put("right", array[1]);
            result.put("left", array[2]);
        } else {
            throw new NotValidSizeArguments();
        }

        return result;
    }
}
