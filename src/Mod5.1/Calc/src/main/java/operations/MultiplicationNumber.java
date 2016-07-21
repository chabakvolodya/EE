package operations;


import api.BinaryOperation;
import api.Operation;

/**
 * Created by Chucky on 03.07.2016.
 */
public class MultiplicationNumber implements Operation, BinaryOperation {

    @Override
    public String execute(String ... value) {
        return String.valueOf(Double.valueOf(value[0]) * Double.valueOf(value[1]));
    }
}
