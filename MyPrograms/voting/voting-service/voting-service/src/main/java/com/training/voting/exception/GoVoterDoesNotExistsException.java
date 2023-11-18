package com.training.voting.exception;

public class GoVoterDoesNotExistsException extends RuntimeException {

	public GoVoterDoesNotExistsException() {}

	public GoVoterDoesNotExistsException(String message) {
		super(message);
	}

}
