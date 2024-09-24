package io.vcti.springSecurityJpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler
	public ResponseEntity<?> exceptionMethod(Exception e)
	{
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access not allowed!");
	}
}
