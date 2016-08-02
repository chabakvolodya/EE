package ua.in.vyshnya.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Chucky on 02.08.2016.
 */
@EnableAspectJAutoProxy
@Aspect
public aspect AOPConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPConfig.class);

    @Pointcut("execution( * ua.in.vyshnya.api.Operation.execute(Object...))")
    private void allOperationsExecute(){}

    @Before("allOperationsExecute()")
    public void traceInputArgsExecute(JoinPoint jp) {

    }
}
