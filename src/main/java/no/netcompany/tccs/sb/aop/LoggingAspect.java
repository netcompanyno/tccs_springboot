package no.netcompany.tccs.sb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long start = System.currentTimeMillis();
        final String className = joinPoint.getTarget().getClass().getName();
        final String methodName = MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName();
        LoggerFactory.getLogger(className).info("Method {} invoked", methodName);

        Object proceed = joinPoint.proceed();

        long timeMs = System.currentTimeMillis() - start;

        LoggerFactory.getLogger(className).info("Method {} took {} millis", methodName, timeMs);

        return proceed;
    }
}
