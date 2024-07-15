package com.tech.app.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.so.AppDetails;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * Tech App Rest Controller Class providing the information about the App
 * 
 * @author Bhushan Bafna
 */
@RestController
@RequestMapping("/app")
@Slf4j
@OpenAPIDefinition(
	info = @Info(title = "Tech App API", description = "Tech App API Description",
		contact = @Contact(name = "Bhushan Bafna", email = "bhushan.bafna")),
	servers = { @Server(url = "http://localhost:8090/tech-app", description = "LOCAL"),
		@Server(url = "http://devl.techapp.com/tech-app", description = "DEVL"),
		@Server(url = "http://test.techapp.com/tech-app", description = "TEST") })
// Using @CrossOrigin(origins = "*") opens your application to all domains, this means any domain can access your endpoints
@CrossOrigin(origins = "*")
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
	@Operation(summary = "Get the current app name and version")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Application Details",
		content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AppDetails.class)) }) })
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
