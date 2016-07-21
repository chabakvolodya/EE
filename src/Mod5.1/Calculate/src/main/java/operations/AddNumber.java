package operations;

import api.BinaryOperation;
import api.Operation;

/**
 * Created by Chucky on 16.07.2016.
 */
public class AddNumber implements Operation, BinaryOperation {

    @Override
    public String execute(String... values) {
        return String.valueOf(Double.valueOf(values[0]) + Double.valueOf(values[1]));
    }
}
