package com.tech.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bhushan Bafna
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMsg;
	
}
