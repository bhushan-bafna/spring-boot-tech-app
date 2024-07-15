package com.tech.app.jdbc.dao;

import lombok.Data;

/**
 * Actor data access object
 * 
 * @author Bhushan Bafna
 */
@Data
public class ActorDAO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String updateOn;
	
}
