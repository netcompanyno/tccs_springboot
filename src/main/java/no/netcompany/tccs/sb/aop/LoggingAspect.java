package no.netcompany.tccs.sb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeMs = System.currentTimeMillis() - start;

        LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName()).info(
                "Method took {} millis");

        return proceed;
    }
}
