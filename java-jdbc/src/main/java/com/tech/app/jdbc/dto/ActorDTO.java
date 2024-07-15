package com.tech.app.jdbc.dto;

import lombok.Data;

/**
 * Actor data transfer object
 * 
 * @author Bhushan Bafna
 */
@Data
public class ActorDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String updateOn;
	
}
