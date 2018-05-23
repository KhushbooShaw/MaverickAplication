package com.stackroute.maverick.exception;

@SuppressWarnings("serial")
public class DatabaseNotAvailableException extends Exception{
	
   public DatabaseNotAvailableException() {
	
    super();
	
  }
   public DatabaseNotAvailableException(String msg)
   {
	   
	super(msg);
	
   }
}
