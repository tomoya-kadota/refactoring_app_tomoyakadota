package jp.co.sss.crud.exception;

public class IllegalInputException extends RuntimeException{

	public IllegalInputException() {
		super();
	}
	
	public IllegalInputException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
