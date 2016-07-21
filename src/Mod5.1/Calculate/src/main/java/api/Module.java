package api;

import exeptions.OperationsIsNotCheckedType;

import java.util.Map;
import java.util.Set;

/**
 * Created by Chucky on 16.07.2016.
 */
public interface Module {

    String execute(Map<String, String> values);
    boolean isValid(Map<String, String> values);
    Set<String> getOperations();
    void setOperation(String name, Operation operation);
}
