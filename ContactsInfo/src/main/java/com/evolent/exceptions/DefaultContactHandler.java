package com.evolent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class DefaultContactHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleException(Exception exception){
		ErrorDetails error = new ErrorDetails(exception.getMessage(),exception.getLocalizedMessage());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
	}

	public final ResponseEntity<Object> handleExceptionall(Exception ex, WebRequest request) throws Exception {
		ErrorDetails error = new ErrorDetails(ex.getMessage(),"Custom Exception");
		return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
