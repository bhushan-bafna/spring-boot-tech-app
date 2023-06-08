package com.tech.app.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Bhushan
 *
 */
@Aspect
@Slf4j
@Component
public class AOPRestControllerLoggingAspect {

	@Around("execution(* com.tech.app.aop.controller.*.*(..))")
	public Object logginMethodExecutionTimeAroundPackage(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("In logginMethodExecutionTimeAroundPackage()");
		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - startTime;
		log.info("{} method executed in {} ms", joinPoint.getSignature().getName(), executionTime);
		return proceed;
	}
	
	@Around("@annotation(com.tech.app.aop.annotation.MethodExecutionTime)")
	public Object logginMethodExecutionTimeForAnnotatedMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("In logginMethodExecutionTimeForAnnotatedMethod()");
		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - startTime;
		log.info("AnnotatedMethod - {} method executed in {} ms", joinPoint.getSignature().getName(), executionTime);
		return proceed;
	}
}
