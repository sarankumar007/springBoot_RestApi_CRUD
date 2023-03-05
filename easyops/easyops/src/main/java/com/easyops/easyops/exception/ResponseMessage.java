package com.easyops.easyops.exception;

public class ResponseMessage {
	private String message;
	private String error = "";
	private String url;
	
	public ResponseMessage(String message, String error, String url) {
		super();
		this.message = message;
		this.error = error;
		this.url = url;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}