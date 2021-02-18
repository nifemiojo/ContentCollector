package com.project.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger((this.getClass()));

    // Define format for logging, for entire application
    @Pointcut("within(com.project.controllers..*)")
    public void definePackagePointcuts() {
        // empty method just to name the location specified in the pointcut
    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp) {
        // This method will run after any method is executed in controllers
        log.debug(" \n \n \n ");
        log.debug("**** Before Method Execution **** \n {}.{} () with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));
        log.debug("_________________________________ \n \n \n");

        Object o = null;

        try {
            o = jp.proceed();
        } catch (Throwable throwable) {

            throwable.printStackTrace();
        }

        log.debug("**** After Method Execution **** \n {}.{} () with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));
        log.debug("_________________________________ \n \n \n");

        return o;
    }
}
