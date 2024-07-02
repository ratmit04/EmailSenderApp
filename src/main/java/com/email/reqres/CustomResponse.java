package com.email.reqres;

import org.springframework.http.HttpStatus;

public class CustomResponse {
	private String message;
	private HttpStatus httpStatus;
	private boolean success;

	public static CustomResponse builder() {
		// TODO Auto-generated method stub
		return new CustomResponse();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
