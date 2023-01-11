package com.tech.app.jdbc.dto;

import lombok.Data;

/**
 * Person data transfer object
 * 
 * @author Bhushan Bafna
 */
@Data
public class PersonDTO {
	
	private Long instanz;
	private String firstName;
	private String lastName;
	private String id;
	
}
