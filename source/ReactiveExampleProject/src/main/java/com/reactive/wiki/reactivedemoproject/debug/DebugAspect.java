package com.reactive.wiki.reactivedemoproject.debug;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DebugAspect {

//    @Before("execution(* com.reactive.wiki.reactivedemoproject.exemplos..*(..))")
//    public void logMethodArgs(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().toShortString();
//        String packageName = joinPoint.getSignature().getDeclaringType().getPackageName();
//        Object[] args = joinPoint.getArgs();
//
//        for (int i = 0; i < args.length; i++) {
//            DebugLogger.log(packageName, "arg" + i, args[i], methodName);
//        }
//    }
//
//    @AfterReturning(pointcut = "execution(* com.reactive.wiki.reactivedemoproject.exemplos..*(..))", returning = "result")
//    public void logMethodReturn(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().toShortString();
//        String packageName = joinPoint.getSignature().getDeclaringType().getPackageName();
//        DebugLogger.log(packageName, "returnValue", result, methodName);
//    }
}

