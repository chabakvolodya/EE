package ua.in.vyshnya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.vyshnya.SuperCalc;
import ua.in.vyshnya.api.Calc;
import ua.in.vyshnya.api.Module;
import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.modules.ModuleDate;
import ua.in.vyshnya.modules.ModuleNumber;
import ua.in.vyshnya.operations.*;

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
