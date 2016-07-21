package modules;

import api.*;
import exeptions.OperationsIsNotCheckedType;
import operations.AddNumber;
import operations.SubtractionNumber;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Chucky on 16.07.2016.
 */
public class NumberModule extends TemplateModule {

    {
        operations.put("+", new AddNumber());
        operations.put("-", new SubtractionNumber());
    }

    @Override
    public String execute(Map<String, String> values) {

        double result;

        if (operations.get(values.get("operation")) instanceof UnaryOperation) {
            result = Double.valueOf(operations.get(values.get("operation")).execute(values.get("right")));
        } else {
            result = Double.valueOf(operations.get(values.get("operation")).execute(values.get("left"), values.get("right")));
        }

        return ((long)result == result) ? String.valueOf((long)result) : String.valueOf(result);
    }

    @Override
    public boolean isValid(Map<String, String> values) {

        boolean result = true;

        if (!operations.containsKey(values.get("operation"))) return false;

        if (operations.get(values.get("operation")) instanceof UnaryOperation) {

            if (values.size() != 2) {
                return false;
            } else {
                if (!isNumeric(values.get("right"))) return false;
            }
        }

        if (operations.get(values.get("operation")) instanceof BinaryOperation) {

            if (values.size() != 3) {
                return false;
            } else {
                if (!isNumeric(values.get("right")) || !isNumeric(values.get("left"))) return false;
            }
        }

        return result;
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
