package com.idat.pe.ec3.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.pe.ec3.Model.Usuario;
import com.idat.pe.ec3.Repository.UsuarioClienteRepository;

import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repository.findByUsuario(username);
		if(usuario != null) {
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority(usuario.getRol());
			listGranted.add(granted);
			
			return new User(usuario.getUsuario(),usuario.getPassword(),listGranted);
			
		}else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}

	}
	
	

}
