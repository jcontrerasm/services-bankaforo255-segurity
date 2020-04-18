package com.app.aforo255.segurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.app.aforo255.segurity.dao.UserDao;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.*;

@Service
public class UserService implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao client;
			
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.app.aforo255.segurity.models.entity.User user = client.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Error en login");
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role-> new SimpleGrantedAuthority(role.getNombre()))
				.peek(autority -> log.info("Role: " + autority.getAuthority()))
				.collect(Collectors.toList());
		log.info("Usuario autenticado: " + username);
		
		return new User(user.getUsername(),user.getPassword(),user.getEnabled(),true, true, true,authorities);
	}
}
