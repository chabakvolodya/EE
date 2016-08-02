package ua.in.vyshnya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.in.vyshnya.api.Calc;
import ua.in.vyshnya.config.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chucky on 30.07.2016.
 */
public class Runner {

    private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private static Calc calc = context.getBean("lib", Calc.class);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            System.out.println("Input:");

            String expression = reader.readLine();

            if (expression.equals("exit")) break;

            System.out.println(calc.execute(expression));
        }
    }
}
