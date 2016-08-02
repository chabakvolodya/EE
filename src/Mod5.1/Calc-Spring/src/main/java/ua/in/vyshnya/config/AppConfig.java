package ua.in.vyshnya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.vyshnya.SuperCalc;
import ua.in.vyshnya.api.Calc;
import ua.in.vyshnya.api.Module;
import ua.in.vyshnya.api.Operation;
import ua.in.vyshnya.modules.ModuleDate;
import ua.in.vyshnya.operations.OperationDateAdd;
import ua.in.vyshnya.operations.OperationDateSubtraction;
import ua.in.vyshnya.operations.OperationNumberAdd;

/**
 * Created by Chucky on 30.07.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    Operation operationDateAdd() {
        return new OperationDateAdd();
    }

    @Bean
    Operation operationDateSubtraction() {
        return new OperationDateSubtraction();
    }

    @Bean
    Module moduleDate() {
        Module moduleDate = new ModuleDate();
        moduleDate.setOperation("+", operationDateAdd());
        moduleDate.setOperation("-", operationDateSubtraction());

        return moduleDate;
    }

    @Bean
    Calc lib() {
        Calc calc = new SuperCalc();
        calc.setModule("date", moduleDate());

        return calc;
    }
}
