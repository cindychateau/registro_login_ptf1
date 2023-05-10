package com.codingdojo.cynthia.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	/* Método que me va a registrar un nuevo usuario
	 * Recibir un usuario, Recibir los posibles errores
	 * Regresar usuario creado, null 
	 * */
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		
		//Revisamos que el correo que recibimos no exista en nuestra tabla de usuarios
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //NULL o Objeto Usuario
		if(existeUsuario != null) {
			//El correo ya está registrado
			//result.rejectValue("email", "Unique", "El correo ingresado ya está en uso");
			result.rejectValue("email", "Unique", "El correo ingresado ya está en uso");
		}
		
		//Comparamos contraseñas 
		String contrasena = nuevoUsuario.getContrasena();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) { //! -> Lo contrario
			//result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
			result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
		}
		
		//Si NO existe error, guardamos!
		if(result.hasErrors()) {
			return null;
		} else {
			//Encriptamos contraseña
			//String contra_encriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
			String contra_encriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
			nuevoUsuario.setContrasena(contra_encriptada);
			return repoUsuarios.save(nuevoUsuario);
		}
		
		
	}
	
	/*
	 * email = "elena@codingdojo.com"
	 * password = "Elena1234"
	 * existeUsuario = Obj(Elena) ->nombre, contrasena, email, etc
	 * BCrypt.checkpw("Elena1234", "$2a$10$Qqf1KDyQFHRKCKSqwBh5pO6lPMKl8S3EZSE4TXULInW0lb7DcuoD2")
	 * ---TRUE regresa existeUsuario
	 * ---FALSE regresa null
	 */
	public Usuario login(String email, String password) {
		
		//Buscar que el correo recibido esté en BD
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //NULL o Objeto de Usuario
		if(existeUsuario == null) {
			return null;
		}
		
		//Comparamos contraseñas
		//BCrypt.checkpw(Contraseña NO encriptada, Contraseña encriptada) -> True o False
		if(BCrypt.checkpw(password, existeUsuario.getContrasena())) {
			return existeUsuario;
		} else {
			return null;
		}
		
	}
	
	
	
}
