package com.mindbowser.grocery.store.management.common.exception;

import javax.servlet.http.HttpServletResponse;

public class GPMException extends Exception {

	private final int statusCode;

	public GPMException() {
		
		this.statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	}

	public GPMException(String err, int code) {
		super(err);
		this.statusCode = code;
	}
}
