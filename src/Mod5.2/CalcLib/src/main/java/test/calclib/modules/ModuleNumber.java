package test.calclib.modules;

import test.calclib.api.OperationBinaryFlag;
import test.calclib.api.OperationUnaryFlag;
import test.calclib.operations.*;

import java.util.Map;

/**
 * Created by Chucky on 29.07.2016.
 */
public class ModuleNumber extends ModuleTemplate {

    @Override
    public boolean isAble(Map<String, Object> input) {

        validation(input);
        boolean result = true;
        String nameOperation = String.valueOf(input.get("operation"));

        if (operations.get(nameOperation) instanceof OperationUnaryFlag) {

            if (!isNumeric((String) input.get("right"))) return false;

        } else if (operations.get(nameOperation) instanceof OperationBinaryFlag) {

            if (!isNumeric((String) input.get("right")) || !isNumeric((String) input.get("left"))) return false;

        }

        return result;
    }

    @Override
    public String execute(Map<String, Object> input) {

        validation(input);  //Validation InputDATA
        double result = 0;
        String nameOperation = String.valueOf(input.get("operation"));
        Object right;
        Object left;

        if (operations.get(nameOperation) instanceof OperationUnaryFlag) {

            right = input.get("right");
            result = Double.valueOf(operations.get(nameOperation).execute(right));

        } else if (operations.get(nameOperation) instanceof OperationBinaryFlag){

            right = input.get("right");
            left = input.get("left");
            result = Double.valueOf(operations.get(nameOperation).execute(left, right));

        }

        return ((long)result == result) ? String.valueOf((long)result) : String.valueOf(result);
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
