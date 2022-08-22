package com.example.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestResponseStatus  extends RuntimeException {

	
	public BadRequestResponseStatus(String ex) {
		super(ex);
	}


	private static final long serialVersionUID = 1L;

}
