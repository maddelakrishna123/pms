package com.cts.intcdb22jf003.pms.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DuplicateProductException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public  String     handleDuplicateProductException(DuplicateProductException ex)
	{
		return ex.getMessage();
	}
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public  String     handleProductNotFoundException(ProductNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		List<String> errs = new ArrayList<String>();
		
		
	 ex.getBindingResult().getFieldErrors().stream().forEach(t->errs.add(t.getDefaultMessage()));
	/*BindingResult br =	ex.getBindingResult();
	
List<FieldError> objectError =	br.getFieldErrors();
List<String> errs = new ArrayList<String>();
 objectError.stream().forEach(t->errs.add(t.getDefaultMessage()));*/
		return  new  ResponseEntity<Object>(errs,status);
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleAnyException(Exception ex)
	{
		return ex.getMessage();
	}
}
