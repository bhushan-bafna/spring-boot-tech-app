package com.tech.app.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Status Class
 * 
 * @author Bhushan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
	
	private String status = "OK";
	private String message;
	/**
	 * This is the constructor for Status.java
	 *
	 * @param message
	 */
	public Status(String message) {
		this.message = message;
	}
	
}
