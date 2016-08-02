package ua.in.vyshnya.api;

import java.util.Map;

/**
 * Created by Chucky on 29.07.2016.
 */
public interface Parser {
    Map<String, Object> parse(String expression);
}
