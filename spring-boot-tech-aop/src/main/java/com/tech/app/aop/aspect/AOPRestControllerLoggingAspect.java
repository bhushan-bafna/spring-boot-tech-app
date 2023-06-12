package com.tech.app.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

	/**
	 * 
	 * This method will intercept all the method in the class of the package
	 * (com.tech.app.aop.controller.*.*(..)) and com.tech.app.aop.service.*.*(..)
	 * and execute the aspect around all those method to log the method execution
	 * timing
	 *
	 * @param joinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("execution(* com.tech.app.aop.controller.*.*(..)) || execution(* com.tech.app.aop.service.*.*(..))")
	public Object logginMethodExecutionTimeAroundPackage(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("In logginMethodExecutionTimeAroundPackage()");
		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - startTime;
		log.info("{} method executed in {} ms", joinPoint.getSignature().getName(), executionTime);
		return proceed;
	}

	/**
	 * 
	 * This method will intercept all the method annotated with
	 * {@link com.tech.app.aop.annotation.MethodExecutionTime @MethodExecutionTime}
	 * annotation and execute the aspect around those method to log the method
	 * execution timing
	 *
	 * @param joinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("@annotation(com.tech.app.aop.annotation.MethodExecutionTime)")
	public Object logginMethodExecutionTimeForAnnotatedMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("In logginMethodExecutionTimeForAnnotatedMethod()");
		long startTime = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - startTime;
		log.info("AnnotatedMethod - {} method executed in {} ms", joinPoint.getSignature().getName(), executionTime);
		return proceed;
	}

	/**
	 * 
	 * This method will intercept all the method annotated with
	 * {@link com.tech.app.aop.annotation.BeforeMethodExecution @BeforeMethodExecution}
	 * annotation and execute the aspect before those method.
	 *
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("@annotation(com.tech.app.aop.annotation.BeforeMethodExecution)")
	public void beforeMethodExecutionForAnnotatedMethod(JoinPoint joinPoint) throws Throwable {
		log.info("In beforeMethodExecutionForAnnotatedMethod()");
	}

	/**
	 * 
	 * This method will intercept all the method annotated with
	 * {@link com.tech.app.aop.annotation.BeforeMethodExecution @AfterMethodExecution}
	 * annotation and execute the aspect after those method.
	 *
	 * @param joinPoint
	 * @throws Throwable
	 */
	@After("@annotation(com.tech.app.aop.annotation.AfterMethodExecution)")
	public void afterMethodExecutionForAnnotatedMethod(JoinPoint joinPoint) throws Throwable {
		log.info("In afterMethodExecutionForAnnotatedMethod()");
	}

}
