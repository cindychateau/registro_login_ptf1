package com.codingdojo.cynthia.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(String email); //SELECT * FROM usuarios WHERE email = <email>;
	
	//findByCampo(Valor a recibir) -> SELECT * FROM usuarios WHERE campo = <Valor a recibir>
	//findByCampoAndCampo2
	//....OrderByCampo
	
}
