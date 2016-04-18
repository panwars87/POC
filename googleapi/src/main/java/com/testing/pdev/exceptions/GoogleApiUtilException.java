package com.testing.pdev.exceptions;

public class GoogleApiUtilException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Make sure this exception is always given at least a message
	 * Suppress warnings for private method, since it is a known idiom
	 */
	@SuppressWarnings("unused")
	private GoogleApiUtilException(){
		super();
	}
	
	public GoogleApiUtilException(String msg){
		super(msg);
	}
	
	/**
	 * @param message
	 * @param cause - the exception appended to the exception trace
	 */
	public GoogleApiUtilException(String message, Throwable cause) {
        super(message, cause);
    }
	
	@Override
    public String toString() {
        return getMessage();
    }
}
