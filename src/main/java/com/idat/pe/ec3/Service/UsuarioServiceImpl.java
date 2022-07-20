package com.idat.pe.ec3.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec3.Dto.ClienteDTOResponse;
import com.idat.pe.ec3.Dto.UsuarioDTORequest;
import com.idat.pe.ec3.Dto.UsuarioDTOResponse;
import com.idat.pe.ec3.Model.Usuario;
import com.idat.pe.ec3.Repository.UsuarioClienteRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioClienteRepository repo;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		Usuario u  = new Usuario();
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		repo.save(u);
		
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuario) {
		
		Usuario u  = new Usuario();
		u.setIdUsuario(usuario.getIdUsuario());
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		repo.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		
		List<UsuarioDTOResponse> listar  = new ArrayList<>();
		UsuarioDTOResponse dto = null;
		List<Usuario> u = repo.findAll();
		
		for(Usuario usuario: u) {
			
			dto = new UsuarioDTOResponse();
			dto.setUsuario(usuario.getUsuario());
			dto.setPassword(usuario.getPassword());
			dto.setRol(usuario.getRol());
			dto.setIdUsuario(usuario.getIdUsuario());
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtnerUsuarioId(Integer id) {
		
		Usuario usuario = repo.findById(id).orElse(null);
		UsuarioDTOResponse dto = new UsuarioDTOResponse();
		dto.setUsuario(usuario.getUsuario());
		dto.setPassword(usuario.getPassword());
		dto.setRol(usuario.getRol());
		dto.setIdUsuario(usuario.getIdUsuario());
		return dto;

		
	}
	
	

}
