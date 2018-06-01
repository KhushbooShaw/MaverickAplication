package com.stackroute.maverick.exception;

import org.springframework.stereotype.Component;

//custom exception class domain

@SuppressWarnings("serial")
@Component
public class CustomException extends Exception {

	private int code;
	
	private String message;

	public int getCode() {
		
		return code;
		
	}

	public void setCode(int code) {
		
		this.code = code;
		
	}

	public String getMessage() {
		
		return message;
		
	}

	public void setMessage(String message) {
		
		this.message = message;
		
	}

}
