package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//criando a CLASSE/ENTIDADE REPLY q é uma RESPOSTA dos TOPICOS
//
//
//colocando um ANNOTATION @ENTITY para MAPEAR a classe REPLY
//com as ANNOTATION do JPA...
@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition="TEXT")	
	private String body;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;

	//
	//o REPLY/resposta esta ASSOCIADA a TOPICS/topico
	//
	//fazendo a ASSOCIACAO com o TOPICS, pois toda REPLY vai ser de 
	// 1 TOPICO (toda REPLY/resposta precisa ser de 1 topics/topico)
	//
	// ANNOTATION @MANYTOONE(Muitos Para Um) -> 1 REPLY/resposta tem 1 TOPICS/topico
	// e 1 TOPICS/topico pode ter VARIAS REPLY/respostas :)
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	@ManyToMany
	@JoinTable(name = "tb_reply_likes",
		joinColumns = @JoinColumn(name = "reply_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> likes = new HashSet<>();
	
	public Reply() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<User> getLikes() {
		return likes;
	}

	//HASHCODE EQUALS para comparacoes
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
