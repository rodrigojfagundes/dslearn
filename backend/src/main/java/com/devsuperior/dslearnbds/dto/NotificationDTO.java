package com.devsuperior.dslearnbds.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dslearnbds.entities.Notification;

//DTO é um OBJ/CLASSE q serve para FILTRAR transferencia de DADOS... 
//Exemplo temos um OBJ do tipo NOTIFICATION q tem 
//ID, TEXT, MOMENT, READ, ROUTE, etc...  
//Mas queremos q seja transferido para o FRONT apenas o TEXT e
//e o MOMENT... dai usemos o NOTIICATION_DTO...
//Vantagem é Controlar quais dados q vao ser jogados para o 
//RESOURCER/controlador, e assim da mais seguranca e economiza 
//dados na REDE
//
public class NotificationDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String text;
	private Instant moment;
	private boolean read;
	private String route;
	private Long userId;
	
	//construtor vazio
	public NotificationDTO() {
	}
	
	
	
	//construtor com argumentos
	public NotificationDTO(Long id, String text, Instant moment, boolean read, String route, Long userId) {
		super();
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.userId = userId;
	}
	
	
	public NotificationDTO(Notification entity) {
		id = entity.getId();
		text = entity.getText();
		moment = entity.getMoment();
		read = entity.isRead();
		route = entity.getRoute();
		userId = entity.getUser().getId();
	}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public Instant getMoment() {
		return moment;
	}



	public void setMoment(Instant moment) {
		this.moment = moment;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}



	public String getRoute() {
		return route;
	}



	public void setRoute(String route) {
		this.route = route;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}
}