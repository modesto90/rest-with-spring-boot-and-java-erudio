package com.example.responses;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String detais;
	private String Message;
	public ExceptionResponse(Date timestamp, String detais, String message) {
		this.timestamp = timestamp;
		this.detais = detais;
		Message = message;
	}

	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetais() {
		return detais;
	}

	public void setDetais(String detais) {
		this.detais = detais;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
	
}
