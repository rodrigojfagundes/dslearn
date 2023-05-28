package com.devsuperior.dslearnbds.dto;

import java.io.Serializable;

import com.devsuperior.dslearnbds.entities.User;

//DTO é um OBJ/CLASSE q serve para FILTRAR transferencia de DADOS... 
//Exemplo temos um OBJ do tipo USER q tem ID, NAME, EMAIL, PASSWORD,
//etc...  Mas queremos q seja transferido para o FRONT apenas o NOME e
//EMAIL... dai usemos o USER_DTO... Vantagem é Controlar quais dados q
//vao ser jogados para o RESOURCER/controlador, e assim da mais 
//seguranca e economiza dados na REDE
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;

	public UserDTO() {
	}


	public UserDTO(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	

	public UserDTO(User entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
