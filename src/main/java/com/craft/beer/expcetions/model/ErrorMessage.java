package com.craft.beer.expcetions.model;

import java.util.List;

public class ErrorMessage {
	private List<ErrorModelMessage> errors;

	public List<ErrorModelMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorModelMessage> errors) {
		this.errors = errors;
	}

}
