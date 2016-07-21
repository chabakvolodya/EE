package api;

import java.util.Map;

/**
 * Created by Chucky on 21.07.2016.
 */
public interface Calculate {
    String execute(String expression);
    void setModule(String name, Module module);
    Module getModule(String name);
    void setParser(Parser parser);
    Map<String, Module> getModules();
}
