package com.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.app.customer.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        System.out.println(
                "Method call: " + joinPoint.getSignature().getDeclaringType() + " method "
                        + joinPoint.getSignature().getName()
        );
    }
}
