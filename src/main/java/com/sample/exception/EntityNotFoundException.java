package com.sample.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3597234505803926214L;
	
	public EntityNotFoundException(String message) {
	   super(message);
	}
	
}
