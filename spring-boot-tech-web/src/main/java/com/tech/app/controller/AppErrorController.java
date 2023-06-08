package com.tech.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO java docs
 * 
 * @author Bhushan
 *
 */
@RestController
public class AppErrorController implements ErrorController {
	private final static String PATH = "/app/error";

	@RequestMapping(PATH)
	public String getErrorPath() {
		return "No Mapping Found / Invalid Mapping";
	}

}