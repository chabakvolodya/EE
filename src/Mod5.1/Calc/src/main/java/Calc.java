import api.Calculate;
import exeptions.InvalidExpression;
import exeptions.NotFoundModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chucky on 21.07.2016.
 */
public class Calc {

    private Calculate calculate;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private void init() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        calculate = context.getBean("calculate", Calculate.class);
    }

    public void run() throws IOException {

        init();

        while (true) {

            String command = reader.readLine();
            if (command.equals("exit")) break;

            try {
                System.out.println(calculate.execute(command));
            } catch(NotFoundModule e) {
                System.err.println("Не знайдено модуль для обробки задачі");
            } catch (InvalidExpression e) {
                System.err.println("Невірний вираз");
            }

        }

    }
}
