package parsers;

import api.Parser;
import exeptions.InvalidExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chucky on 20.07.2016.
 */
public class DefaultParser implements Parser {

    @Override
    public Map<String, String> parse(String expression) {
        Map<String, String> result = new HashMap<>();
        expression = expression.replaceAll("\\s", "");
        String array[] = expression.split(",");
        if (array.length == 2) {

            result.put("operation", array[0]);
            result.put("right", array[1]);
        } else if (array.length == 3) {

            result.put("operation", array[0]);
            result.put("left", array[1]);
            result.put("right", array[2]);
        } else {
            throw new InvalidExpression("Невірний вираз");
        }

        return result;
    }
}
