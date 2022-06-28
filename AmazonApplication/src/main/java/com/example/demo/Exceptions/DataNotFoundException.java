package com.example.demo.Exceptions;

public class DataNotFoundException extends Exception{
	
	public DataNotFoundException()
	{
		
	}
	
	public DataNotFoundException(String s)
	{
		super(s);
	}
	
	public DataNotFoundException(Exception e)
	{
		super(e);
	}
	
	public DataNotFoundException(String s, Exception e)
	{
		super(s, e);
	}
	
	

}
