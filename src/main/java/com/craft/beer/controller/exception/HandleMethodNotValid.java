package com.craft.beer.controller.exception;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.craft.beer.expcetions.ExceptionResponse;

@ControllerAdvice
public class HandleMethodNotValid extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		List<String> errorMessages = new ArrayList<>();
		for (FieldError fieldError : fieldErrors) {
			errorMessages.add(fieldError.getField() +" - "+ fieldError.getDefaultMessage());
		}
		
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage("Error");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

}
