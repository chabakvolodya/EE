package test.calcspring.operations;

import test.calclib.api.Operation;
import test.calclib.api.OperationBinaryFlag;

import java.time.LocalDate;

/**
 * Created by Chucky on 21.07.2016.
 */
public class OperationDateAdd implements Operation, OperationBinaryFlag {

    @Override
    public String execute(Object... strings) {

        LocalDate leftDate = LocalDate.parse((String)strings[1]);
        LocalDate rightDate = LocalDate.parse((String)strings[0]);

        LocalDate result = leftDate.plusDays(rightDate.getDayOfMonth()).plusMonths(rightDate.getMonthValue()).plusYears(rightDate.getYear());

        return String.format("%d.%d.%d", result.getYear(), result.getMonthValue(), result.getDayOfMonth());
    }
}
