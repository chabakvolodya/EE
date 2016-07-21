import api.Calculate;
import api.Module;
import api.Operation;
import modules.DateModule;
import operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chucky on 21.07.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    Calculate calculate() {

        ImplCalculate calculate = new ImplCalculate();

        calculate.getModule("number").setOperation("sqrt", sqrtNumber());
        calculate.getModule("number").setOperation("fact", factorialNumber());
        calculate.getModule("number").setOperation("log", logNumber());
        calculate.getModule("number").setOperation("*", multiplicationNumber());
        calculate.getModule("number").setOperation("/", divisionNumber());

        calculate.setModule("dateModule", dateModule());
        return calculate;
    }

    @Bean
    Module dateModule() {
        DateModule dateModule = new DateModule();
        dateModule.setOperation("+", new AddDate());
        dateModule.setOperation("-", new SubtractionDate());

        return dateModule;
    }

    @Bean
    Operation sqrtNumber() {
        return new SqrtNumber();
    }

    @Bean
    Operation factorialNumber() {
        return new FactorialNumber();
    }

    @Bean
    Operation logNumber() {
        return new LogNumber();
    }

    @Bean
    Operation multiplicationNumber() {
        return new MultiplicationNumber();
    }

    @Bean
    Operation divisionNumber() {
        return new DivisionNumber();
    }

}
