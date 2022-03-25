package spring.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before(value = "execution(* spring.aop.demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){
        //System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before Loggers with Argument: " + arg);
    }
    @After(value = "execution(* spring.aop.demo.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }
    @Pointcut("execution(* spring.aop.demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()",
    returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning: " + retVal);
    }
}
