package com.stackroute.maverick.exception;

//simple custom exception class

@SuppressWarnings("serial")
public class MyException extends Exception {

	public MyException() {
		
		super();
	
	}

	public MyException(String msg) {
		
		super(msg);
		
	}

}
