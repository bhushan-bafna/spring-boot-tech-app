package com.tech.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Exception is used when any data is not found
 * 
 * @author Bhushan Bafna
 */
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMsg;
	
}
