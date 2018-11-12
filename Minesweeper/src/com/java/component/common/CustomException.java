package com.java.component.common;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6020178411462843338L;
	String message;

	public enum ErrorCodes {

		CELL_ALREADY_CHOOSEN("Cell already choosen"), INVALID_ROW_INPUT("Wrong row input"),
		TOO_MANY_BOMBS("Bombs should be less than the quarter of the grid size");
		String code;

		ErrorCodes(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

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
