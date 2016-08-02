package ua.in.vyshnya.operations;

import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.api.OperationUnaryFlag;

/**
 * Created by Chucky on 03.07.2016.
 */
public class OperationNumberLog implements Operation, OperationUnaryFlag {

    @Override
    public String execute(Object ... values) {

        double right = Double.valueOf(String.valueOf(values[0]));
        return String.valueOf(Math.log(right));
    }
}
