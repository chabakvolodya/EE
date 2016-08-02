package test.calcspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.calclib.SuperCalc;
import test.calclib.api.Module;
import test.calclib.api.Operation;
import test.calclib.api.Calc;
import test.calclib.modules.ModuleNumber;
import test.calclib.operations.*;
import test.calcspring.modules.ModuleDate;
import test.calcspring.operations.OperationDateAdd;
import test.calcspring.operations.OperationDateSubtract;

/**
 * Created by Chucky on 30.07.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    Operation operationDateSubtraction() {
        return new OperationDateSubtract();
    }

    @Bean
    Operation operationDateAdd() {
        return new OperationDateAdd();
    }

    @Bean
    Operation operationNumberAdd() {
        return new OperationNumberAdd();
    }

    @Bean
    Operation operationNumberDivision() {
        return new OperationNumberDivision();
    }

    @Bean
    Operation operationNumberFactorial() {
        return new OperationNumberFactorial();
    }

    @Bean
    Operation operationNumberLog() {
        return new OperationNumberLog();
    }

    @Bean
    Operation operationNumberMultiplication() {
        return new OperationNumberMultiplication();
    }

    @Bean
    Operation operationNumberSqrt() {
        return new OperationNumberSqrt();
    }

    @Bean
    Operation operationNumberSubtract() {
        return new OperationNumberSubtract();
    }

    @Bean
    Module moduleDate() {
        Module moduleDate = new ModuleDate();

        moduleDate.setOperation("+", operationDateAdd());
        moduleDate.setOperation("-", operationDateSubtraction());

        return moduleDate;
    }

    @Bean
    Module moduleNumber() {
        Module moduleNumber = new ModuleNumber();

        moduleNumber.setOperation("+", operationNumberAdd());
        moduleNumber.setOperation("-", operationNumberSubtract());
        moduleNumber.setOperation("*", operationNumberMultiplication());
        moduleNumber.setOperation("/", operationNumberDivision());
        moduleNumber.setOperation("fact", operationNumberFactorial());
        moduleNumber.setOperation("sqrt", operationNumberSqrt());
        moduleNumber.setOperation("log", operationNumberLog());

        return moduleNumber;
    }

    @Bean
    Calc lib() {
        Calc calc = new SuperCalc("number", moduleNumber());
        calc.setModule("date", moduleDate());

        return calc;
    }
}
