package com.craft.beer.controller.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.craft.beer.expcetions.IdMandatoryException;
import com.craft.beer.expcetions.IdRequiredPathException;
import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.expcetions.model.ErrorExceptionModel;


@ControllerAdvice
@RestController
public class GlobalExpcetionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdRequiredPathException.class)
	public ResponseEntity<ErrorExceptionModel> idRequired(IdRequiredPathException idRequiredPathException) {
		ErrorExceptionModel response = new ErrorExceptionModel();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(idRequiredPathException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorExceptionModel>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorExceptionModel> resourceNotFound(ResourceNotFoundException resourceNotFoundException) {
		ErrorExceptionModel response = new ErrorExceptionModel();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(resourceNotFoundException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorExceptionModel>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdMandatoryException.class)
	public ResponseEntity<ErrorExceptionModel> idMandatory(IdMandatoryException idMandatoryException) {
		ErrorExceptionModel response = new ErrorExceptionModel();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(idMandatoryException.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorExceptionModel>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorExceptionModel> constraintViolation(ConstraintViolationException constraintViolation){
		ErrorExceptionModel response = new ErrorExceptionModel();
		response.setErrorCode("BAD_REQUEST");
		response.setErrorMessage(constraintViolation.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorExceptionModel>(response, HttpStatus.BAD_REQUEST);
		
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<List<ErrorModelMessage>> handleRequestException(MethodArgumentNotValidException exception) {
//		List<ErrorModelMessage> errorMessages = exception.getBindingResult().getFieldErrors().stream()
//				.map(err -> new ErrorModelMessage(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
//				.distinct().collect(Collectors.toList());
//		return new ResponseEntity<List<ErrorModelMessage>>(errorMessages, HttpStatus.BAD_REQUEST);
//
//	}

}
