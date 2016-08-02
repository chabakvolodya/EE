package ua.in.vyshnya.api;

import java.util.Map;

/**
 * Created by Chucky on 29.07.2016.
 */
public interface Module {

    boolean isAble(Map<String, Object> input);
    String execute(Map<String, Object> input);
    void setOperation(String name, Operation operation);
    void setOperations(Map<String, Operation> operations);
    void addOperations(Map<String, Operation> operations);
    String getOperationsName();
}
