package com.tech.app.so;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * POJO for holding Application Details
 * 
 * @author Bhushan Bafna
 */
@Data
@ToString
@AllArgsConstructor
public class AppDetails {
	
	private String appName;
	private String appVersion;
	
}
