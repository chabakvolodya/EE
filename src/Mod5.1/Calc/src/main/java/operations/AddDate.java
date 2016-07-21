package operations;

import api.BinaryOperation;
import api.Operation;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Chucky on 21.07.2016.
 */
public class AddDate implements Operation, BinaryOperation {

    @Override
    public String execute(String... strings) {

        LocalDate leftDate = LocalDate.parse(strings[1]);
        LocalDate rightDate = LocalDate.parse(strings[0]);

        LocalDate result = leftDate.plusDays(rightDate.getDayOfMonth()).plusMonths(rightDate.getMonthValue()).plusYears(rightDate.getYear());

        return String.format("%d.%d.%d", result.getYear(), result.getMonthValue(), result.getDayOfMonth());
    }
}
