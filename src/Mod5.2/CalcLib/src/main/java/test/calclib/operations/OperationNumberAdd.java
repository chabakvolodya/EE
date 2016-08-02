package test.calclib.operations;

import test.calclib.api.*;

/**
 * Created by Chucky on 29.07.2016.
 */
public class OperationNumberAdd implements Operation, OperationBinaryFlag {

    @Override
    public String execute(Object... values) {

        double right = Double.valueOf(String.valueOf(values[0]));
        double left = Double.valueOf(String.valueOf(values[1]));

        return String.valueOf(left + right);
    }
}
