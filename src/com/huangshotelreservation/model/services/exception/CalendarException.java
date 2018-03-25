package com.huangshotelreservation.model.services.exception;

public class CalendarException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8287557163053450025L;

	public CalendarException(final String inputMessage)
	{
		super(inputMessage);
	}
	
	public CalendarException(final String inputMessage,final Throwable nestedException)
	{
		super(inputMessage,nestedException);
	}
}
