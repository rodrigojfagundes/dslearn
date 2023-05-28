package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//
//criando a CLASSE/ENTIDADE LESSON/aulas do tipo ABSTRACT...
//
//ABSTRACT -> pois a CLASSE LESSON NAO pode ser INSTANCIADA
//pois toda LESSON vai ser OU um TASK/tarefa ou CONTENT/conteudo
//o TASK e CONTENT são os 2 TIPOS de SUBCLASSE da LESSON
//
//colocando um ANNOTATION @ENTITY para MAPEAR a classe LESSON
//com as ANNOTATION do JPA... 
@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	@OneToMany(mappedBy = "lesson")
	private List<Deliver> deliveries = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tb_lessons_done",
		joinColumns = @JoinColumn(name = "lesson_id"),
		inverseJoinColumns = {
				@JoinColumn(name = "user_id"),
				@JoinColumn(name = "offer_id")
		}
	)
	private Set<Enrollment> enrollmentsDone = new HashSet<>();
	
	//criando o construtor sem argumentos
	public Lesson() {
	}
	
	//construtor com argumentos
	public Lesson(Long id, String title, Integer position, Section section) {
		super();
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
	}
	
	
	//criando os get e set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}

	public List<Deliver> getDeliveries() {
		return deliveries;
	}

	//colocando o HASHCODE EQUALS para fazer comparacoes
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
		Lesson other = (Lesson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
