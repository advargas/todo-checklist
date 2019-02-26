package com.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Entity not found")
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 7596674857793570865L;
	
	private static final String MESSAGE = "Entity not found";
	
	public NotFoundException() {
		super(MESSAGE);
	}

}
