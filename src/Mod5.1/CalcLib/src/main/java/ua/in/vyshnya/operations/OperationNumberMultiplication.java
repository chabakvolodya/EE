package ua.in.vyshnya.operations;

import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.api.OperationBinaryFlag;

/**
 * Created by Chucky on 03.07.2016.
 */
public class OperationNumberMultiplication implements Operation, OperationBinaryFlag {

    @Override
    public String execute(Object... values) {

        double right = Double.valueOf(String.valueOf(values[0]));
        double left = Double.valueOf(String.valueOf(values[1]));

        return String.valueOf(left * right);
    }
}
