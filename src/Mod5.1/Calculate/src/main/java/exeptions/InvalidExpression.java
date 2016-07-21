package exeptions;

/**
 * Created by Chucky on 19.07.2016.
 */
public class InvalidExpression extends RuntimeException {
    public InvalidExpression(String message) {
        super(message);
    }
}
