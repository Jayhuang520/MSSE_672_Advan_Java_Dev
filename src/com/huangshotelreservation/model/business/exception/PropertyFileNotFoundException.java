package com.huangshotelreservation.model.business.exception;

public class PropertyFileNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 998162440903235567L;

	public PropertyFileNotFoundException(final String inputMessage,final Throwable inException)
	{
		super(inputMessage,inException);
	}
}//end class PropertyFileNotFoundException
