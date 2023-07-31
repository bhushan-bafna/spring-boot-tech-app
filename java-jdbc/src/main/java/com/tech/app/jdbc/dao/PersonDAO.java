package com.tech.app.jdbc.dao;

import lombok.Data;

/**
 * Person data access object
 * 
 * @author Bhushan Bafna
 */
@Data
public class PersonDAO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
}
