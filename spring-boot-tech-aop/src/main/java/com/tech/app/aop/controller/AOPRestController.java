package com.tech.app.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.aop.annotation.AfterMethodExecution;
import com.tech.app.aop.annotation.BeforeMethodExecution;
import com.tech.app.aop.annotation.MethodExecutionTime;
import com.tech.app.aop.service.AOPService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app")
@Slf4j
public class AOPRestController {

	@Autowired
	private AOPService aopService;

	/**
	 * 
	 * When below method is called logginMethodExecutionTimeAroundPackage() of
	 * Aspect is executed Around (before and after) this method. This method calls
	 * aopService.serviceMethod(), thus aspect
	 * (logginMethodExecutionTimeAroundPackage()) is also executed around this
	 * serviceMethod() and will log execution time for both method using
	 * corresponding configured aspect.
	 * <p>
	 * Additionally, when method from same class is called aspect is executed only
	 * for first method() and not for the annotatedMethod().
	 *
	 * @return String
	 * @throws InterruptedException
	 */
	@GetMapping("/aop/method/aspect")
	public String method() throws InterruptedException {
		log.info("In methodAspect()");
//		annotatedMethod();
		aopService.serviceMethod();
		Thread.sleep(5000);
		return "methodAspect() called successfully...!!!";
	}

	/**
	 * 
	 * This method is service which is annotated with @MethodExecutionTime, which
	 * will execute the Aspect - logginMethodExecutionTimeForAnnotatedMethod()
	 * around this method.
	 *
	 * @return String
	 * @throws InterruptedException
	 */
	@MethodExecutionTime
	@GetMapping("/aop/annotation/around/aspect")
	public String annotatedAroundMethod() throws InterruptedException {
		log.info("In annotatedAroundMethod()");
		Thread.sleep(5000);
		return "annotationAspect() called successfully...!!!";
	}

	/**
	 * 
	 * This method is service which is annotated with @BeforeMethodExecution, which
	 * will execute the Aspect - beforeMethodExecutionForAnnotatedMethod() before
	 * this method.
	 *
	 * @return String
	 * @throws InterruptedException
	 */
	@BeforeMethodExecution
	@GetMapping("/aop/annotation/before/aspect")
	public String annotatedBeforeMethod() throws InterruptedException {
		log.info("In annotatedBeforeMethod()");
		Thread.sleep(5000);
		return "annotatedBeforeMethod() called successfully...!!!";
	}

	/**
	 * 
	 * This method is service which is annotated with @AfterMethodExecution, which
	 * will execute the Aspect - afterMethodExecutionForAnnotatedMethod() after this
	 * method.
	 *
	 * @return String
	 * @throws InterruptedException
	 */
	@AfterMethodExecution
	@GetMapping("/aop/annotation/after/aspect")
	public String annotatedAfterMethod() throws InterruptedException {
		log.info("In annotatedAfterMethod()");
		Thread.sleep(5000);
		return "annotatedAfterMethod() called successfully...!!!";
	}

}
