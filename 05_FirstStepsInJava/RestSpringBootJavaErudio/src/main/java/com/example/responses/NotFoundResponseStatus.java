package com.example.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResponseStatus  extends RuntimeException {

	
	public NotFoundResponseStatus(String ex) {
		super(ex);
	}


	private static final long serialVersionUID = 1L;

}
