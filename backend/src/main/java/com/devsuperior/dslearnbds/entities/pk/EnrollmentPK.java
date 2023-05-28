package com.devsuperior.dslearnbds.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.User;

//
//ENROLMENTPK é uma CLASSE AUXILIAR e essa classe vai pegar 
//o ID/REFERENCIA USUARIO(user_id) + o ID/referencia da OFERTA 
//(offer_id) e criar a REFERENCIA entre o USUARIO/aluno e a OFERTA... 
//Ai a ENROLLMENTPK vai ter um ID dela propia q sera passado como ID
//para a CLASSE ENROLLMENT
//
//
//a ANNOTATION @EMBEDDABLE serve para dizer q ESSA CLASSE(ENROLLMENTPK)
//é uma CLASSE q ta definindo ATRIBUTOS de OUTRA CLASSE da (ENROLLMENT)
//
@Embeddable
public class EnrollmentPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//declarando os atributos do tipo USER e OFFER
	//
	//usando a ANNOTATION @MANYTOONE(Muitos para Um) ->1 USER tem pd 
	//ter MUITOS ENROLLMENTPK... Mas 1 ENROLLMENTPK so tem 1 USER 
	//
	//com a ANNOTATION @JOINCOLUN nos
	//vamos informar o nome da COLUNA q tera a CHAVE ESTRANGEIRA 
	//no BANCO e essa chave vai informar QUAL o ID do USER q
	//ta ASSOCIADO com essa CLASSE ENROLLMENTPK, no caso o nome e 
	//USER_ID 
	//
	//ou seja na TABELA ENROLLMENTPK nos vamos ter uma COLUNA com uma
	//CHAVE ESTRANGEIRA informando qual vai ser o ID do USER q
	//ta ASSOCIADO a esse ENROLLMENTPK
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//
	//usando a ANNOTATION @MANYTOONE(Muitos para Um) ->1 OFFER tem pd 
	//ter MUITOS ENROLLMENTPK... Mas 1 ENROLLMENTPK so tem 1 OFFER 
	//
	//com a ANNOTATION @JOINCOLUN nos
	//vamos informar o nome da COLUNA q tera a CHAVE ESTRANGEIRA 
	//no BANCO e essa chave vai informar QUAL o ID da OFFER q
	//ta ASSOCIADO com essa CLASSE ENROLLMENTPK, no caso o nome e 
	//OFFER_ID 
	//
	//ou seja na TABELA ENROLLMENTPK nos vamos ter uma COLUNA com uma
	//CHAVE ESTRANGEIRA informando qual vai ser o ID do OFFER q
	//ta ASSOCIADO a esse ENROLLMENTPK
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	//criando o construtor vazio
	public EnrollmentPK() {
	}

	//criando o construtor com argumentos
	public EnrollmentPK(User user, Offer offer) {
		super();
		this.user = user;
		this.offer = offer;
	}

	//declarando os GET e SET
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	//declarando os HASHCODE EQUALS para fazer comparacoes
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		EnrollmentPK other = (EnrollmentPK) obj;
		if (offer == null) {
			if (other.offer != null)
				return false;
		} else if (!offer.equals(other.offer))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
