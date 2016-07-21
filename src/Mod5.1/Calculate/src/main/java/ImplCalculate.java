import api.Calculate;
import api.Module;
import api.Parser;
import exeptions.InvalidExpression;
import exeptions.NotFoundModule;
import modules.NumberModule;
import parsers.DefaultParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by Chucky on 16.07.2016.
 */
public class ImplCalculate implements Calculate{

    private Map<String, Module> modules = new TreeMap<>();
    private Parser parser = new DefaultParser();

    {
        modules.put("number", new NumberModule());
    }

    public String execute(String expression) {

        Map<String, String> elements = parser.parse(expression);
        String result = "";
        boolean fount = false;

        for (Module m : modules.values()) {

            if (m.isValid(elements)) {
                result = m.execute(elements);
                fount = true;
                break;
            }
        }

        if (!fount) {
            throw new NotFoundModule("Не знайдено модуль для обробки задачі");
        }

        return result;
    }

    public void setModule(String name, Module module) {
        modules.put(name,module);
    }

    public Module getModule(String name) {
        return modules.get(name);
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Map<String, Module> getModules() {
        return modules;
    }


}
