package com.tech.app.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.so.AppDetails;

import lombok.extern.slf4j.Slf4j;

/**
 * Tech App Rest Controller Class providing the information about the App
 * 
 * @author Bhushan Bafna
 *
 */
@RestController
@RequestMapping("/app")
@Slf4j
public class TechAppController {

	@Value("${project.name}")
	private String appName;

	@Value("${project.version}")
	String appVersion;

	/**
	 * This method is to get the App Name
	 * 
	 */
	@GetMapping("/details")
	public AppDetails getAppName() {
		AppDetails appDetails = new AppDetails(appName, appVersion);
		log.info("AppDetails : {}", appDetails.toString());
		log.trace("AppDetails : {}", appDetails.toString());
		log.debug("AppDetails : {}", appDetails.toString());
		log.warn("AppDetails : {}", appDetails.toString());
		log.error("AppDetails : {}", appDetails.toString());
		log.info("root logger : {}", Logger.ROOT_LOGGER_NAME);
		return appDetails;
	}

}
