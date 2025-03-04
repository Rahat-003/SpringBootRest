package com.example.SpringBootRest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name, (args)

    @Before("execution(* com.example.SpringBootRest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method call: " + jp.getSignature().getName());
    }

    @After("execution(* com.example.SpringBootRest.service.JobService.getJob(..)) || " +
                "execution(* com.example.SpringBootRest.service.JobService.updateJob(..))")
    public void logAfter(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.SpringBootRest.service.JobService.getJob(..)) || " +
            "execution(* com.example.SpringBootRest.service.JobService.updateJob(..))")
    public void logAfterCrash(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.SpringBootRest.service.JobService.getJob(..)) || " +
            "execution(* com.example.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully: " + jp.getSignature().getName());
    }

}
