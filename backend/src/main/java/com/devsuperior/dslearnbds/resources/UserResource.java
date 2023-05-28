package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.UserService;



//classe para fazer chamada dos RECURSOS REST dos OBJETOS do tipo
//USER... Ou seja quando o JAVASCRIPT q ta rodando no FRONT
//requisitar os USUARIOS, ele o JS vai chamar os metodos dessa
//classe aqui, a classe USERRESOURCE, e ESSA CLASSE chama
//a classe USERSERVICE, q roda os METODOS solicitados
//
//para dizer q essa classe é um CONTROLADOR REST, vamos por o
//@RESTCONTROLLER... e o @RequestMapping e para dizer qual a ROTA
//do recurso... ou seja (localhost:8080/users)

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	

	// criando um METODO/ENDPOINT para retornar um USUARIO pelo o ID
	// do USUARIO
	//
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO dto = service.findById(id);

		return ResponseEntity.ok().body(dto);
	}
	
}
