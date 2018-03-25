package com.huangshotelreservation.model.services.exception;

public class SeeGalleryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3272603462545621625L;

	public SeeGalleryException(final String inputMessage)
	{
		super(inputMessage);
	}
	
	public SeeGalleryException(final String inputMessage,Throwable nestedException)
	{
		super(inputMessage,nestedException);
	}
}
