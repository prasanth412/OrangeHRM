package com.htcindia.orange.helpers;

@SuppressWarnings("serial")
/*tells Java not to remind you that you’ve omitted something called a
 serialVersionUID field. In other words, the SuppressWarnings annotation tells Java not to display a warning*/
 public class MyException extends Exception
{
	/* <---------- Throw My Own Exceptions ---------> */
	public MyException(String errorMessage)
	{
		super(errorMessage);
	}


}
