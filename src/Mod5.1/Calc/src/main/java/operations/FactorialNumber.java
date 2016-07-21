package operations;

import api.Operation;
import api.UnaryOperation;

/**
 * Created by Chucky on 03.07.2016.
 */
public class FactorialNumber implements Operation, UnaryOperation {

    @Override
    public String execute(String ... value) {
        return String.valueOf(factorial(Long.valueOf(value[0])));
    }

    private long factorial( long n ) {

        if( n <= 1 ) {
            return 1;
        } else {
            return n * factorial( n - 1 );
        }
    }
}
