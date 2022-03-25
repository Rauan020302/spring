package spring.aop.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.springframework.web.server.ResponseStatusException;
import spring.aop.demo.handler.TaskException;

@Aspect
@Configuration
public class AspectConfig {

    /**
     * Logging
     * Exception Handling
     * TimeTaken
     */
    private final Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* spring.aop.demo.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        log.info("Executing {}", joinPoint);
    }
    @After(value = "execution(* spring.aop.demo.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        log.info("Complete execution of {}",joinPoint);
    }
    @Around(value = "execution(* spring.aop.demo.service.*.*(..))")
    public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object o = joinPoint.proceed();
            return o;
        }catch (TaskException e){
            log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
            log.info("TaskException Message {}",e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
    @Around(value = "execution(* spring.aop.demo.controller.*.*(..))")
    public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {

        long stratTime=System.currentTimeMillis();

        try {
            Object obj=joinPoint.proceed();
            long timeTaken=System.currentTimeMillis()-stratTime;
            log.info("Time taken by {} is {}",joinPoint,timeTaken);
            return obj;
        }
        catch(TaskException e) {
            log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
            log.info("TaskException Message {}",e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
