package com.cem.globalException;

public class GlobalCustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3118072939411731410L;
	//exception info
	private String message;
	public GlobalCustomException(String message) {
		super(message);
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
