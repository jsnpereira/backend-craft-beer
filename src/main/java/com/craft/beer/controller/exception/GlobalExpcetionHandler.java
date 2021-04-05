package com.craft.beer.controller.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.craft.beer.expcetions.ExceptionResponse;
import com.craft.beer.expcetions.IdMandatoryException;
import com.craft.beer.expcetions.IdRequiredPathException;
import com.craft.beer.expcetions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExpcetionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdRequiredPathException.class)
	public ResponseEntity<ExceptionResponse> idRequired(IdRequiredPathException idRequiredPathException) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(idRequiredPathException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException resourceNotFoundException) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(resourceNotFoundException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdMandatoryException.class)
	public ResponseEntity<ExceptionResponse> idMandatory(IdMandatoryException idMandatoryException) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(idMandatoryException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
