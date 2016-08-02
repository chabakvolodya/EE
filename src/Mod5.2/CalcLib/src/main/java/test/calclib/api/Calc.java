package test.calclib.api;

import java.util.Map;

/**
 * Created by Chucky on 30.07.2016.
 */
public interface Calc {
    String execute(String expression);
    void setModules(Map<String, Module> modules);
    void setModule(String nameModule, Module module);
    void setParser(Parser parser);
    Module getModule(String nameModule);
    String getModulesName();
}
