package com.unibuc.assig.FinalProject.aspect;

import com.unibuc.assig.FinalProject.exceptions.notFoundExceptions.AnObjectNotFound;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.unibuc.assig.FinalProject.services.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.unibuc.assig.FinalProject.services.*.*(..))")   //step 3 - define the advice
    public Object log(ProceedingJoinPoint joinPoint) {
        //step 4 - implement the aspect logic
        log.info("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " will be executed. Timestamp: " + LocalDateTime.now());
        Object object = null;
        try {
            object = joinPoint.proceed();    //invokes the target object's method
            //allows the execution to continue to call the real method which is aspected
        } catch (Throwable e) {
            RequestContextHolder.getRequestAttributes().setAttribute("error_msg", e.getMessage(), 0);
            log.info("Method " + joinPoint.getSignature().getName() +
                    " from " + joinPoint.getTarget().getClass() +
                    " finished the execution with Exception: " + e.getMessage() + " type of exception " + e.getClass() + " Timestamp: " + LocalDateTime.now());
            throw new AnObjectNotFound(e.getMessage());
        }
        log.info("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " finished the execution. Timestamp: " + LocalDateTime.now());
        return object;
    }
}
