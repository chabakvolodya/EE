package api;

import java.util.Map;

/**
 * Created by Chucky on 20.07.2016.
 */
public interface Parser {
    Map<String, String> parse(String expression);
}
