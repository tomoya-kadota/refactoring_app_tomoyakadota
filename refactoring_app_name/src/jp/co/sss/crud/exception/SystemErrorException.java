package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception{

	public SystemErrorException() {
		super();
	}
	
	public SystemErrorException(String errorMessage,Exception e) {
		super(errorMessage,e);
	}
}
