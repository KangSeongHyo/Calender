package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 로그 AOP 설정
 */
@Aspect
@Component
public class LogAop {

    private static Logger logger = LoggerFactory.getLogger(LogAop.class);


    @Before("execution(* com.example.demo.service.*Impl.*(..))")
    public void startService(JoinPoint joinPoint) {
        String log = "[Started] Class = ";
        log += joinPoint.getTarget().getClass().getName()
                +" / Method = " + joinPoint.getSignature().getName()
                +"-----------------------";
        logger.info(log);
    }


    @AfterReturning("execution(* com.example.demo.service.*Impl.*(..))")
    public void endService(JoinPoint joinPoint) {
        String log = "[Completed] Class = ";
        Object[] args = joinPoint.getArgs();

        log += joinPoint.getTarget().getClass().getName();
        log += " / Method = " + joinPoint.getSignature().getName() + "[";

        for(int i = 0; i < args.length; i++){
            log += args[i];
            if(i!=args.length-1){
                log += ",";
            }
        }
        log += "]-----------------------";
        logger.info(log);
    }
    @AfterThrowing("execution(* com.example.demo.service.*Impl.*(..))")
    public void occurredError(JoinPoint joinPoint) {
        String log = "[Exception] Class = ";
        Object[] args = joinPoint.getArgs();

        log += joinPoint.getTarget().getClass().getName();
        log += " / Method = " + joinPoint.getSignature().getName() + "[";

        for(int i = 0; i < args.length; i++){
            log += args[i];
            if(i!=args.length-1){
                log += ",";
            }
        }
        log += "]-----------------------";
        logger.error(log);
    }

}
