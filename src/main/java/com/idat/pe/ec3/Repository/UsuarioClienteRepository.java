package com.idat.pe.ec3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.ec3.Model.Usuario;

public interface UsuarioClienteRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsuario(String usuario);

}
