package test.calcspring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import test.calclib.api.OperationBinaryFlag;
import test.calclib.api.OperationUnaryFlag;


/**
 * Created by Chucky on 02.08.2016.
 */
@Aspect
@EnableAspectJAutoProxy
public class AOPConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPConfig.class);

    @Pointcut("execution( * test.calclib.api.Operation.execute(Object...))")
    private void allOperationsExecute(){}

    @Pointcut("execution( * test.calclib.api.Calc.execute(String)))")
    private void calcExecute(){}

    @Before("allOperationsExecute() && args(values)")
    public void traceInputArgsExecute(JoinPoint jp, Object... values) {

        Object target = jp.getTarget();

        String strResult = "";

        if (target instanceof OperationUnaryFlag) {
            strResult = String.format("Operation execute %s: [%s];", target.getClass().getSimpleName(), values[0]);
        } else if (target instanceof OperationBinaryFlag) {
            strResult = String.format("Operation execute %s: [%s, %s];", target.getClass().getSimpleName(), values[0], values[1]);
        }
        LOGGER.trace(strResult);
    }

    @AfterReturning(pointcut = "allOperationsExecute() && args(values)", returning = "result")
    public void debugResult(JoinPoint jp, Object result,  Object...values) {

        Object target = jp.getTarget();
        String strResult = "";

        if (target instanceof OperationUnaryFlag) {
            strResult = String.format("Operation execute %s: [%s] = result[%s];", target.getClass().getSimpleName(), values[0], result);
        } else if (target instanceof OperationBinaryFlag) {
            strResult = String.format("Operation execute %s: [%s, %s] = result[%s];", target.getClass().getSimpleName(), values[0], values[1], result);
        }
        LOGGER.debug(strResult);
    }

    @Before("calcExecute() && args(expression)")
    public void traceInputCalc(JoinPoint jp, String expression) {

        Object target = jp.getTarget();

        String strResult = "";

        strResult = String.format("Calc input: [%s];", expression);

        LOGGER.trace(strResult);
    }

    @AfterReturning(pointcut = "calcExecute() && args(expression)", returning = "result")
    public void debugInputCalc(JoinPoint jp, Object result, String expression) {

        Object target = jp.getTarget();

        String strResult = "";

        strResult = String.format("Calc input: [%s] = [%s];", expression, result);

        LOGGER.debug(strResult);
    }

    @AfterThrowing(pointcut = "calcExecute() && args(expression)", throwing = "ex")
    public void debugInputCalcException(JoinPoint jp, Throwable ex, String expression) {

        Object target = jp.getTarget();

        String strResult = "";

        strResult = String.format("Calc input: [%s] = ERROR [%s];", expression, ex);

        LOGGER.error(strResult);
    }
}
