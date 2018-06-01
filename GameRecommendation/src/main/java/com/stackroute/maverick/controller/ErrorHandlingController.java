package com.stackroute.maverick.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stackroute.maverick.exception.CustomException;
import com.stackroute.maverick.exception.ExceptionResponse;

@ControllerAdvice
public class ErrorHandlingController {
	
    // method for handling exception in ResponseEntity
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception exception) throws Exception {
		
		//initialising the exception object and setting the  code and description

		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		exceptionResponse.setDescription(exception.getMessage());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 // method for handling custom exception in ResponseEntity
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> customException(Exception exception) throws CustomException {
		
		//initialising the exception object and setting the  code and description

		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());

		exceptionResponse.setDescription(exception.getMessage());

		System.out.println(exception.getMessage());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
