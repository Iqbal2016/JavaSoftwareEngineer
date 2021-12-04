package com.microservice.transaction.service.bean;

public class WSResponse {
	private String outcome;
	private String message;
	private Object data;
	private String[] error;

	public static WSResponse createSuccess(String msg, Object data) {
		WSResponse wsResponse = new WSResponse();
		wsResponse.outcome = "success";
		wsResponse.message = msg;
		wsResponse.data = data;
		return wsResponse;
	}
	
	public static WSResponse createFailure(String msg, String[] error) {
		WSResponse wsResponse = new WSResponse();
		wsResponse.outcome = "error";
		wsResponse.message = msg;
		wsResponse.error = error;
		return wsResponse;
	}


	public String[] getError() {
		return error;
	}

	public void setError(String[] error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public WSResponse(String outcome, String message, Object data) {
		super();
		this.outcome = outcome;
		this.message = message;
		this.data = data;
	}

	public WSResponse(String outcome, String message, String[] error) {
		super();
		this.outcome = outcome;
		this.message = message;
		this.error = error;
	}

	public WSResponse() {
		super();
	}

	public String getOutcome() {
		return outcome;
	}

	public String getMessage() {
		return message;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
