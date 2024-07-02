package com.email.reqres;

public class EmailRequest {

	private String to;
	private String subject;
	private String message;

	public EmailRequest() {

		// TODO Auto-generated constructor stub
	}

	public EmailRequest(String to, String subject, String message) {

		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}
}
