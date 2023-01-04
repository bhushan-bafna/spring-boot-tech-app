package com.tech.app.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.jdbc.dto.PersonDTO;
import com.tech.app.jdbc.service.JavaJdbcService;

import lombok.extern.slf4j.Slf4j;

/**
 * JavaJDBController Class is used to get data from Database using JDBC connection
 * 
 * @author Bhushan Bafna
 *
 */
@RestController
@RequestMapping("/app")
@Slf4j
public class JavaJDBController {
	
	@Autowired
	private JavaJdbcService javaJDBCService;
	
	/**
	 * This method is to get the App Name
	 * @throws Exception 
	 * 
	 */
	@GetMapping("/data/java/jdbc/{id}")
	public PersonDTO getDataUsingJavaJDBC(@PathVariable("id") String id) throws Exception {
		log.info("getDataUsingJavaJDBC(), id - {}", id);
		return javaJDBCService.getDataUsingJavaJDBC(id);
	}

}
