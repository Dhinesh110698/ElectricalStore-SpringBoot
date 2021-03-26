package com.mindgate.eelectricalstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class Valid {

	
	public ResponseEntity<Object> validating(ValidaterException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
