package com.tech.app.exception.model;

import lombok.Data;

/**
 * @author Bhushan Bafna
 *
 */
@Data
public class ErrorResponse {
	
	private String code;
	private String message;

}
