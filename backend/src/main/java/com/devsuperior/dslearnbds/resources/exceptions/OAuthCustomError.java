package com.devsuperior.dslearnbds.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthCustomError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String error;

	@JsonProperty("error_description")
	private String errorDescription;
	
	//construtor vazio
	public OAuthCustomError() {
	}
	
	
	//construtor com argumentos
	public OAuthCustomError(String error, String errorDescription) {
		super();
		this.error = error;
		this.errorDescription = errorDescription;
	}
	
	
	//get e set
	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getErrorDescription() {
		return errorDescription;
	}


	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	
	
	
	
	
	
}
