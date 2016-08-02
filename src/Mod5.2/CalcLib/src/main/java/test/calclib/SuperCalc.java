package test.calclib;

import test.calclib.api.*;
import test.calclib.exceptions.NotFoundModule;
import test.calclib.parsers.ParserDefault;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chucky on 30.07.2016.
 */
public class SuperCalc implements Calc {

    private Map<String, Module> modules = new HashMap<>();
    private Parser parser = new ParserDefault();

    public SuperCalc(String name, Module module) {
        this.modules.put(name, module);
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
