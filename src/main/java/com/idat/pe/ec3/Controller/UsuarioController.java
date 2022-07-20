package com.idat.pe.ec3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.pe.ec3.Dto.UsuarioDTORequest;
import com.idat.pe.ec3.Dto.UsuarioDTOResponse;
import com.idat.pe.ec3.Service.UsuarioService;

@Controller
@RequestMapping("/usuario/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioDTOResponse>> listar(){
		return new ResponseEntity<List<UsuarioDTOResponse>>(service.listarUsuario(), HttpStatus.OK) ;
		
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioDTORequest usuario) {
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioDTOResponse usuario = service.obtnerUsuarioId(id);
		if(usuario != null) {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UsuarioDTORequest usuario){
		
		UsuarioDTOResponse u = service.obtnerUsuarioId(usuario.getIdUsuario());
		if(u != null) {
			service.actualizarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTOResponse> obtenerId(@PathVariable Integer id){
		
		UsuarioDTOResponse u = service.obtnerUsuarioId(id);
		if(u != null) {
			return new ResponseEntity<UsuarioDTOResponse>(service.obtnerUsuarioId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<UsuarioDTOResponse>(HttpStatus.NOT_FOUND);
	}

}
