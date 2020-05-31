package com.blitzware.brazukacarclean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blitzware.brazukacarclean.model.RoleModel;
import com.blitzware.brazukacarclean.model.UserModel;
import com.blitzware.brazukacarclean.repository.RoleRepository;
import com.blitzware.brazukacarclean.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	public UserModel newUser(UserModel dto) {
		dto.getLogin().setRole(roleRepository.findByRoleName("ROLE_USER").orElse(new RoleModel(null, null)));
		return userRepository.save(dto);
	}
}
