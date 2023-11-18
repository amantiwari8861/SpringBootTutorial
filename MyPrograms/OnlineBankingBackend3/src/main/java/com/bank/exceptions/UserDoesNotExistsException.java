package com.bank.exceptions;

public class UserDoesNotExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistsException() {}

	public UserDoesNotExistsException(String message) {
		super(message);
	}
}
