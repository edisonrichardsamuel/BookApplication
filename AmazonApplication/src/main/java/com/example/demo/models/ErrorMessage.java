package com.example.demo.models;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	private String message;
	private LocalDateTime time;
	private String exceptionType;
	
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @return the exceptionType
	 */
	public String getExceptionType() {
		return exceptionType;
	}

	/**
	 * @param exceptionType the exceptionType to set
	 */
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public ErrorMessage() {
	}

	public ErrorMessage(String message, LocalDateTime time, String exceptionType) {
		super();
		this.message = message;
		this.time = time;
		this.exceptionType = exceptionType;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + ", time=" + time + ", exceptionType=" + exceptionType + "]";
	}
	
	

}
