package com.rest.services.util;

public class RestResponse {

	private Integer responseCode;
	private String message;

	public RestResponse(Integer responseCode) {
		super();
		this.responseCode = responseCode;
	}

	public RestResponse(Integer responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public Integer getResponse() {
		return responseCode;
	}

	public void setResponse(Integer response) {
		this.responseCode = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
