package operations;

import api.Operation;
import api.UnaryOperation;

/**
 * Created by Chucky on 03.07.2016.
 */
public class LogNumber implements Operation, UnaryOperation {

    @Override
    public String execute(String ... value) {
        return String.valueOf(Math.log(Double.valueOf(value[0])));
    }
}
