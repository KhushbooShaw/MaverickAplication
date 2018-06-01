package com.stackroute.maverick.exception;

//the class is for creating object of exception

public class ExceptionThrower {
	
	//method for exception class
	
	public void throwGeneralException() throws Exception {
		
		throw new Exception("it is general exception");
		
	}
	
	//method for custom exception class

	public void throwCustomException() throws CustomException {
		
		CustomException customException = new CustomException();
		
		customException.setCode(10);
		
		customException.setMessage("it is custom exception");
		
		throw customException;
		
	}
}
