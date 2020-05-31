package com.blitzware.brazukacarclean.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blitzware.brazukacarclean.model.LoginModel;
import com.blitzware.brazukacarclean.repository.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginModel user = loginRepository.findByEmail(email).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails findById(Long id) {
		LoginModel user = loginRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado com o id : " + id));
		return UserPrincipal.create(user);
	}
}