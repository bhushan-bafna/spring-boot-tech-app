package com.tech.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.app.dao.impl.JavajdbcDaoImpl;

/**
 * @author Bhushan Bafna
 *
 */
@Service
public class JavaJdbcService {
	
	@Autowired
	private JavajdbcDaoImpl javajdbcDaoImpl;
	

	public String getDataUsingJavaJDBC() {
		
		return javajdbcDaoImpl.getData();
		
	}

}
