package ua.in.vyshnya.modules;

import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.api.OperationBinaryFlag;
import ua.in.vyshnya.api.OperationUnaryFlag;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;


/**
 * Created by Chucky on 21.07.2016.
 */
public class ModuleDate extends ModuleTemplate {

    @Override
    public String execute(Map<String, Object> map) {
        String result;
        if (operations.get(map.get("operation")) instanceof OperationUnaryFlag) {
            result = operations.get(map.get("operation")).execute(map.get("right"));
        } else {
            result = operations.get(map.get("operation")).execute(map.get("left"), map.get("right"));
        }

        return result;
    }

    @Override
    public boolean isAble(Map<String, Object> map) {

        boolean result = true;

        if (!operations.containsKey(map.get("operation"))) return false;

        if (operations.get(map.get("operation")) instanceof OperationUnaryFlag) {

            if (map.size() != 2) {
                return false;
            } else {
                try {
                    LocalDate.parse((String)map.get("right"));
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
        }

        if (operations.get(map.get("operation")) instanceof OperationBinaryFlag) {

            if (map.size() != 3) {
                return false;
            } else {
                try {
                    LocalDate.parse((String)map.get("left"));
                    LocalDate.parse((String)map.get("right"));
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
        }

        return result;
    }
}
