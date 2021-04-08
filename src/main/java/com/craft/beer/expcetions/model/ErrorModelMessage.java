package com.craft.beer.expcetions.model;

public class ErrorModelMessage {
	private String fieldName;
	private Object rejectedValue;
	private String messageError;

	public ErrorModelMessage(String fieldName, Object rejectedValue, String messageError) {
		super();
		this.fieldName = fieldName;
		this.rejectedValue = rejectedValue;
		this.messageError = messageError;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	

}
