package com.tech.app.aop.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Bhushan
 *
 */
@Service
@Slf4j
public class AOPService {

	public void serviceMethod() throws InterruptedException {
		log.info("In servceMethod().....");
		Thread.sleep(5000);
	}

}
