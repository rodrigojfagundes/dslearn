package com.devsuperior.dslearnbds.resources.exceptions;

import java.io.Serializable;

//
//classe FIELDMESSAGE
//e uma classe AUXILIAR PARA 
//para colocar no STANDARDERROR(classe STANDARDERROR)
//uma LISTA DE ERROS...
//
//POIS vamos chamar o STANDARDERROR e para ele (standarderror)
//vamos passar uma lista de FIELDMESSAGE q tera o NOME DO CAMPO
//de ERRO e a MENSAGEM de ERRO
//
//essa classe vai servir para CARREGAR O NOME DO CAMPO
//e a MENSAGEM DELE, no caso a mensagem de erro

//EX: FIELDMNAME = CAMPO NAME
//MESSAGE = Entre 5 e 60 caracteres...


public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	

	public FieldMessage() {	
	}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	

	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}	
}