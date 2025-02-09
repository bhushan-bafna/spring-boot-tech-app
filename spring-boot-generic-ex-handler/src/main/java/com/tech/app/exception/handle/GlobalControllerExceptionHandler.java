package com.tech.app.exception.handle;

import java.sql.SQLException;

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
 * This class is the Global Exception Handler. This class will handle exception
 * will be handled in here which occur anywhere in application
 * 
 * @author Bhushan Bafna
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

	/**
	 * Exception handler method for catching NotFoundException.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Data not found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
	public ResponseEntity<ErrorResponse> handleNotFound(RuntimeException ex) {
		log.info("excetion in handler");
		NotFoundException nFex = (NotFoundException) ex;
		ErrorResponse error = new ErrorResponse();
		error.setCode(nFex.getErrorCode());
		error.setMessage(nFex.getErrorMsg());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception handler method for catching SQLException.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ApiResponses(value = { @ApiResponse(responseCode = "500", description = "SQL Exception Occured", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
	public ResponseEntity<ErrorResponse> handleSQLException(SQLException ex) {
		log.info("excetion in handler");
		ErrorResponse error = new ErrorResponse();
		error.setCode("SQL_ERROR");
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Generic Exception handler method for catching any Exception.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ApiResponses(value = { @ApiResponse(responseCode = "500", description = "Generic exception occured", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
	public ResponseEntity<ErrorResponse> handleBookNotFound(Exception ex) {
		log.error("Generic Excetion in handler: ", ex);
		ErrorResponse error = new ErrorResponse();
		error.setCode("GENERIC");
		error.setMessage("Generic Exception");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
