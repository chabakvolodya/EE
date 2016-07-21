package exeptions;

/**
 * Created by Chucky on 19.07.2016.
 */
public class NotFoundModule extends RuntimeException {
    public NotFoundModule(String message) {
        super(message);
    }
}
