package com.tech.app.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.aop.annotation.MethodExecutionTime;
import com.tech.app.aop.service.AOPService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app")
@Slf4j
public class AOPRestController {
	
	@Autowired
	private AOPService aopService;
	
	@GetMapping("/aop/method/aspect")
	public String method() throws InterruptedException {
		log.info("In methodAspect()");
//		annotatedMethod();
		aopService.serviceMethod();
		Thread.sleep(5000);
		return "methodAspect() called successfully...!!!";
	}
	
	@MethodExecutionTime
	@GetMapping("/aop/annotation/aspect")
	public String annotatedMethod() throws InterruptedException {
		log.info("In annotationAspect()");
		Thread.sleep(5000);
		return "annotationAspect() called successfully...!!!";
	}

}
