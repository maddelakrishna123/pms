package com.cts.intcdb22jf003.pms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateProductException extends RuntimeException {

	public DuplicateProductException(String message) {
		super(message);
		
	}
	
	

}
