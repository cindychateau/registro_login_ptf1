package com.codingdojo.cynthia.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	/* Método que me va a registrar un nuevo usuario
	 * Recibir un usuario, Recibir los posibles errores
	 * Regresar usuario creado, null 
	 * */
	
}
