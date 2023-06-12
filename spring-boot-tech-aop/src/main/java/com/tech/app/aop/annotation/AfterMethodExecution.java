package com.tech.app.aop.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * AfterMethodExecution is the marker annotation to mark the method to be scan
 * by the Aspect in order to perform the given task after execution of method
 * 
 * @author Bhushan
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AfterMethodExecution {

}
