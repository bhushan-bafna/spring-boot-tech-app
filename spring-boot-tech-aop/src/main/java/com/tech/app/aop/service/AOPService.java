package com.tech.app.aop.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * This is service class
 * 
 * @author Bhushan
 *
 */
@Service
@Slf4j
public class AOPService {

	/**
	 * 
	 * This method is serviceMethod()
	 *
	 * @throws InterruptedException
	 */
	public void serviceMethod() throws InterruptedException {
		log.info("In servceMethod().....");
		Thread.sleep(5000);
	}

}
