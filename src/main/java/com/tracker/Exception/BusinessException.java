package com.tracker.Exception;

/**
 * The Class BusinessException.
 */
public class BusinessException extends Exception{
	
	/**
	 * Instantiates a new business exception.
	 *
	 * @param s the s
	 */
	public BusinessException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }

}
