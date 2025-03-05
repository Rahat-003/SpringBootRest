package com.example.SpringBootRest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.SpringBootRest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp, int postId) throws Throwable {

        if (postId < 0) {
            LOGGER.error("Invalid postId: {}", postId);
            LOGGER.info("postId is negative");
            postId = -postId;
        }

        Object obj = pjp.proceed(new Object[]{postId});
        return obj;
    }
}
