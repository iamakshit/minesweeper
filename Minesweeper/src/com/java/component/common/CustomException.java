package com.java.component.common;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6020178411462843338L;
	String message;

	enum ErrorCodes {

	}

	public CustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
