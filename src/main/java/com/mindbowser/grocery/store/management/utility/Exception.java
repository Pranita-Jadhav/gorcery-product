package com.mindbowser.grocery.store.management.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Exception extends RuntimeException {
	public Exception(String exception) {
		super(exception);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}