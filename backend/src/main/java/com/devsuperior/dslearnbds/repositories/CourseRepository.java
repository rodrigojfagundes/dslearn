package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslearnbds.entities.Course;

//criando a interface COURSE REPOSITORY, q irá fazer receber
//as solicitações da CLASSE COURSESERVICE... e em sequencia
//a COUSEREPOSITORY irá fazer a conexao ao BANCO para
//realizar a solicitacao
	//e essa interface HERDA METODOS de JPAREPOSITORY para se conectar
	//ao BANCO, o JPAREPOSITORY recebe um TIPO da ENTIDADE
	//no caso COURSE, e um ID, q vai ser no formato LONG
	//
	//colocando o @REPOSITORY para dizer q o COURSEREPOSITORY
	//é uma DEPEDENCIA injetavel... e INJETAMOS ELA no COURSESERVICE
	//com o @REPOSITORY os OBJ de COURSEREPOSITORY passam a ser
	//gerenciados pelo o SPRINGBOOT
public interface CourseRepository extends JpaRepository<Course, Long>{

}
