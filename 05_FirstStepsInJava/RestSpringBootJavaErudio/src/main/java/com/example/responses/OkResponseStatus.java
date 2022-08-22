package com.example.responses;

public class OkResponseStatus extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OkResponseStatus(String message) {
		super(message);
	}
	

}
