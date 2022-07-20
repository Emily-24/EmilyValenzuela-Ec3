package com.idat.pe.ec3.Service;

import java.util.List;

import com.idat.pe.ec3.Dto.UsuarioDTORequest;
import com.idat.pe.ec3.Dto.UsuarioDTOResponse;



public interface UsuarioService {
	
	void guardarUsuario(UsuarioDTORequest usuario);
	void actualizarUsuario(UsuarioDTORequest usuario);
	void eliminarUsuario(Integer id);
	List<UsuarioDTOResponse> listarUsuario();
	UsuarioDTOResponse obtnerUsuarioId(Integer id);

}
