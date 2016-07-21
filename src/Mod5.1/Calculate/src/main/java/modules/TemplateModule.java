package modules;

import api.BinaryOperation;
import api.Module;
import api.Operation;
import api.UnaryOperation;
import exeptions.OperationsIsNotCheckedType;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Chucky on 21.07.2016.
 */
public abstract class TemplateModule implements Module {

    protected Map<String, Operation> operations = new TreeMap<>();

    @Override
    public void setOperation(String name, Operation operation) {

        if (!(operation instanceof BinaryOperation) && !(operation instanceof UnaryOperation))
            throw new OperationsIsNotCheckedType("Операція не позначина як унарна чи бінарна");

        operations.put(name, operation);
    }

    @Override
    public abstract String execute(Map<String, String> values);

    @Override
    public abstract boolean isValid(Map<String, String> values);

    @Override
    public Set<String> getOperations() {
        return operations.keySet();
    }
}
