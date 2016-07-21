package modules;

import api.BinaryOperation;
import api.UnaryOperation;
import operations.SubtractionDate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;


/**
 * Created by Chucky on 21.07.2016.
 */
public class DateModule extends TemplateModule {

    {
        operations.put("+", new SubtractionDate());
    }

    @Override
    public String execute(Map<String, String> map) {
        String result;
        if (operations.get(map.get("operation")) instanceof UnaryOperation) {
            result = operations.get(map.get("operation")).execute(map.get("right"));
        } else {
            result = operations.get(map.get("operation")).execute(map.get("left"), map.get("right"));
        }

        return result;
    }

    @Override
    public boolean isValid(Map<String, String> map) {

        boolean result = true;

        if (!operations.containsKey(map.get("operation"))) return false;

        if (operations.get(map.get("operation")) instanceof UnaryOperation) {

            if (map.size() != 2) {
                return false;
            } else {
                try {
                    LocalDate.parse(map.get("right"));
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
        }

        if (operations.get(map.get("operation")) instanceof BinaryOperation) {

            if (map.size() != 3) {
                return false;
            } else {
                try {
                    LocalDate.parse(map.get("left"));
                    LocalDate.parse(map.get("right"));
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
        }

        return result;
    }
}
