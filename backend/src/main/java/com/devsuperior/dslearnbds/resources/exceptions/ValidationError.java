package com.devsuperior.dslearnbds.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	

	private List<FieldMessage> errors = new ArrayList<>();
	
	//GET para a lista de nome ERROS do tipo FIELDMESSAGE
	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String message) {

		errors.add(new FieldMessage(fieldName, message));
	}
}
