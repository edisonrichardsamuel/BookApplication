package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exceptions.DataNotFoundException;
import com.example.demo.models.ErrorMessage;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(DataNotFoundException e) {
		return new ResponseEntity<ErrorMessage>( new ErrorMessage(
				e.getMessage(),
				LocalDateTime.now(),
				e.getClass().toString()), HttpStatus.OK);
		
	}

}
