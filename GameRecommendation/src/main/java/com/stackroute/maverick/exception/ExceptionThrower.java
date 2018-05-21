package com.stackroute.maverick.exception;

public class ExceptionThrower {
	
	public void throwGeneralException() throws Exception {
		
		throw new Exception("it is general exception");
		
	}

	public void throwCustomException() throws CustomException {
		
		CustomException customException = new CustomException();
		
		customException.setCode(10);
		
		customException.setMessage("it is custom exception");
		
		throw customException;
		
	}
}
