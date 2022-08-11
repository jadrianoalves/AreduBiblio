package com.aredu.biblio.erros.dto;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

public class DefaultError {

	private LocalTime timestamp;
	private final int code;
	private final String message;
	
	
	public DefaultError(int code, String message) {
		this.timestamp = LocalTime.now();
		this.code = code;
		this.message = message;
	}


	public int getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}
	
	public LocalTime getTimestamp() {
		return this.timestamp;
	}
	
	
}
