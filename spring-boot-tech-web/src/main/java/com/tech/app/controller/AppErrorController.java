package com.tech.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppErrorController isuse in case when consumer is calling some service that
 * is not existing. In this case the request is redirected to path /app/error
 * (configured in application.yml by property server.error.path) which then
 * comes to this controller and corresponding message is returned
 * 
 * @author Bhushan
 *
 */
@RestController
public class AppErrorController implements ErrorController {
	private final static String PATH = "/app/error";

	/**
	 * 
	 * This method is used to provide the message for /app/error request.
	 *
	 * @return String
	 */
	@RequestMapping(PATH)
	public String getErrorPath() {
		return "No Mapping Found / Invalid Mapping";
	}

}