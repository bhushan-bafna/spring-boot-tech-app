package com.tech.app.aop.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * MethodExecutionTime is the marker annotation to mark the method to be scan by
 * the Aspect in order to log the execution time of annotation method
 * 
 * @author Bhushan
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface MethodExecutionTime {

}
