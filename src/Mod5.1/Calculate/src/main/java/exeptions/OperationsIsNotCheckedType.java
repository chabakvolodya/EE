package exeptions;

/**
 * Created by Chucky on 19.07.2016.
 */
public class OperationsIsNotCheckedType extends RuntimeException {
    public OperationsIsNotCheckedType(String message) {
        super(message);
    }
}
