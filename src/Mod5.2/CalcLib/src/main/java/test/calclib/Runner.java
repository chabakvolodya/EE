package test.calclib;

import test.calclib.api.Calc;
import test.calclib.modules.ModuleNumber;
import test.calclib.operations.*;

/**
 * Created by Chucky on 02.08.2016.
 */
public class Runner {

    private static Calc calc;

    static {
        final ModuleNumber moduleNumber = new ModuleNumber();

        moduleNumber.setOperation("+", new OperationNumberAdd());
        moduleNumber.setOperation("-", new OperationNumberSubtract());
        moduleNumber.setOperation("*", new OperationNumberMultiplication());
        moduleNumber.setOperation("/", new OperationNumberDivision());
        moduleNumber.setOperation("log", new OperationNumberLog());
        moduleNumber.setOperation("fact", new OperationNumberFactorial());
        moduleNumber.setOperation("sqrt", new OperationNumberSqrt());
        calc = new SuperCalc("number", moduleNumber);
    }

    public static void main(String[] args) {
        System.out.println(calc.execute("+, 2, 5"));
    }
}
