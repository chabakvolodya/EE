package test.calclib.operations;

import test.calclib.api.*;

/**
 * Created by Chucky on 03.07.2016.
 */
public class OperationNumberFactorial implements Operation, OperationUnaryFlag {

    @Override
    public String execute(Object ... values) {

        long right = Long.valueOf(String.valueOf(values[0]));
        return String.valueOf(factorial(right));
    }

    private long factorial( long n ) {

        if( n <= 1 ) {
            return 1;
        } else {
            return n * factorial( n - 1 );
        }
    }
}
