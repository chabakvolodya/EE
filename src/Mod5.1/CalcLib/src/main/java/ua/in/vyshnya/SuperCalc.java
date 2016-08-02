package ua.in.vyshnya;

import ua.in.vyshnya.api.Calc;
import ua.in.vyshnya.api.Module;
import ua.in.vyshnya.api.Parser;
import ua.in.vyshnya.exceptions.NotFoundModule;
import ua.in.vyshnya.parsers.ParserDefault;
import ua.in.vyshnya.modules.ModuleNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chucky on 30.07.2016.
 */
public class SuperCalc implements Calc {

    private Map<String, Module> modules = new HashMap<>();
    private Parser parser = new ParserDefault();

    {
        modules.put("number", new ModuleNumber());
    }

    public String execute(String expression) {

        String exp = expression;
        Map<String, Object> elements = parser.parse(expression);
        String result = "";
        boolean fount = false;

        for (Module m : modules.values()) {

            if (m.isAble(elements)) {
                result = m.execute(elements);
                fount = true;
                break;
            }
        }

        if (!fount) {
            throw new NotFoundModule();
        }

        return exp + " = " + result;
    }

    @Override
    public void setModules(Map<String, Module> modules) {
        this.modules = modules;
    }

    @Override
    public void setModule(String nameModule, Module module) {
        modules.put(nameModule, module);
    }

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Module getModule(String nameModule) {
        return modules.get(nameModule);
    }

    @Override
    public String getModulesName() {
        return modules.keySet().toString();
    }
}
