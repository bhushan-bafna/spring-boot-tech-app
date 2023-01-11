package com.tech.app.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.jdbc.dto.PersonDTO;
import com.tech.app.jdbc.service.JavaJdbcService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * JavaJDBController Class is used to get data from Database using JDBC
 * connection
 * 
 * @author Bhushan Bafna
 */
@RestController
@RequestMapping("/app")
@Slf4j
public class JavaJDBCController {
	
	@Autowired
	private JavaJdbcService javaJDBCService;
	
	/**
	 * This method is to get the person details based on id
	 * 
	 * @throws Exception
	 * 
	 */
	@GetMapping("/data/java/jdbc/{id}")
	@Operation(summary = "Get the person details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetch Person Details for given id",
		content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class)) }) })
	public PersonDTO getDataUsingJavaJDBC(@PathVariable("id") String id) throws Exception {
		log.info("getDataUsingJavaJDBC(), id - {}", id);
		return javaJDBCService.getDataUsingJavaJDBC(id);
	}
	
}
