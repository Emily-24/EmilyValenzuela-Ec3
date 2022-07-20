package com.idat.pe.ec3.Service;

import java.util.List;

import com.idat.pe.ec3.Dto.ClienteDTORequest;
import com.idat.pe.ec3.Dto.ClienteDTOResponse;


public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarclientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
