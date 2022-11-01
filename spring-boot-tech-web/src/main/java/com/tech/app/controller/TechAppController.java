package com.tech.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.so.AppDetails;

/**
 * Tech App Rest Controller Class providing the information about the App
 * 
 * @author Bhushan Bafna
 *
 */
@RestController
@RequestMapping("/app")
public class TechAppController {

	Logger logger = LoggerFactory.getLogger(TechAppController.class);

	@Value("${project.name}")
	private String appName;

	/**
	 * This method is to get the App Name
	 * 
	 */
	@GetMapping("/details")
	public AppDetails getAppName(@Value("${project.name}") String appName, @Value("${project.version}") String appVersion) {
		AppDetails appDetails = new AppDetails(appName, appVersion);
		logger.info("AppDetails : {}", appDetails.toString());
		logger.trace("AppDetails : {}", appDetails.toString());
		logger.debug("AppDetails : {}", appDetails.toString());
		logger.warn("AppDetails : {}", appDetails.toString());
		logger.error("AppDetails : {}", appDetails.toString());
		logger.info("root logger : {}", Logger.ROOT_LOGGER_NAME);
		return appDetails;
	}

}
