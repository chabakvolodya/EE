package ua.in.vyshnya.modules;

import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.api.OperationBinaryFlag;
import ua.in.vyshnya.api.OperationUnaryFlag;
import ua.in.vyshnya.api.Module;
import ua.in.vyshnya.exceptions.NotFoundOperation;
import ua.in.vyshnya.exceptions.NotValidSizeArgumentsThisOperationType;
import ua.in.vyshnya.exceptions.OperationIsNotCheckedFlag;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chucky on 29.07.2016.
 */
public abstract class ModuleTemplate implements Module {

    protected final int SIZE_UNARY_ARGUMENTS = 2;
    protected final int SIZE_BINARY_ARGUMENTS = 3;

    protected Map<String, Operation> operations = new HashMap<>();

    @Override
    public abstract boolean isAble(Map<String, Object> input);

    @Override
    public abstract String execute(Map<String, Object> input);

    protected void validation(Map<String, Object> input) {

        String nameOperation = String.valueOf(input.get("operation"));

        if (!operations.containsKey(nameOperation)) {

            throw new NotFoundOperation();

        } else if (!(operations.get(nameOperation) instanceof OperationUnaryFlag) && !(operations.get(nameOperation) instanceof OperationBinaryFlag)){

            throw new OperationIsNotCheckedFlag();

        }

//        if (!(operations.get(nameOperation) instanceof OperationUnaryFlag || input.size() == SIZE_UNARY_ARGUMENTS) && !(operations.get(nameOperation) instanceof OperationBinaryFlag || input.size() == SIZE_BINARY_ARGUMENTS)) {
//
//            throw new NotValidSizeArgumentsThisOperationType();
//
//        }

        if (operations.get(nameOperation) instanceof OperationUnaryFlag) {

            if (input.size() != SIZE_UNARY_ARGUMENTS) throw new NotValidSizeArgumentsThisOperationType();

        } else if (operations.get(nameOperation) instanceof OperationBinaryFlag) {

            if (input.size() != SIZE_BINARY_ARGUMENTS) throw new NotValidSizeArgumentsThisOperationType();
        }
    }

    @Override
    public String getOperationsName() {
        return operations.keySet().toString();
    }

    @Override
    public void setOperation(String name, Operation operation) {
        operations.put(name,operation);
    }

    @Override
    public void setOperations(Map<String, Operation> operations) {
        this.operations = operations;
    }

    @Override
    public void addOperations(Map<String, Operation> operations) {
        this.operations.putAll(operations);
    }
}
