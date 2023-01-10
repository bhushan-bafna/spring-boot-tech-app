package com.tech.app.exception.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.app.exception.NotFoundException;
import com.tech.app.exception.model.ErrorResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is the Global exception handler.
 * 
 * @author Bhushan Bafna
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Data not found", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
	public ResponseEntity<ErrorResponse> handleBookNotFound(RuntimeException ex) {
		log.info("excetion in handler");
		ErrorResponse error = new ErrorResponse();
		error.setCode("NOTFOUND");
		error.setMessage("No data Found");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ApiResponses(value = { @ApiResponse(responseCode = "500", description = "Generic exception occured", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
	public ResponseEntity<ErrorResponse> handleBookNotFound(Exception ex) {
		log.info("Generic Excetion in handler");
		ErrorResponse error = new ErrorResponse();
		error.setCode("GENERIC");
		error.setMessage("Generic Exception");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
