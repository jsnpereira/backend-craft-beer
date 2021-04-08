package com.craft.beer.expcetions.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorExceptionModel {
	private String errorMessage;
	private String errorCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	

	public ErrorExceptionModel() {

	}

	public ErrorExceptionModel(String errorMessage, String errorCode, LocalDateTime timestamp) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
