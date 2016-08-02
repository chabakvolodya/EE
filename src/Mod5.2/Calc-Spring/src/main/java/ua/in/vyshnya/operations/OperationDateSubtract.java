package ua.in.vyshnya.operations;

import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.api.OperationBinaryFlag;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Chucky on 21.07.2016.
 */
public class OperationDateSubtract implements Operation, OperationBinaryFlag {

    @Override
    public String execute(Object... strings) {

        LocalDate leftDate = LocalDate.parse((String)strings[1]);
        LocalDate rightDate = LocalDate.parse((String)strings[0]);

        Period period = Period.between(leftDate, rightDate);

        return String.format("%d.%d.%d", period.getYears(), period.getMonths(), period.getDays());
    }
}
