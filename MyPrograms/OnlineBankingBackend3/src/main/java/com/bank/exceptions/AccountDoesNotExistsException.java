package com.bank.exceptions;

public class AccountDoesNotExistsException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public AccountDoesNotExistsException() {}

	public AccountDoesNotExistsException(String message) {
		super(message);
	}

}
