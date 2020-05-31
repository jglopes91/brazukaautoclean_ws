package com.blitzware.brazukacarclean.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.blitzware.brazukacarclean.constants.APIConstants;
import com.blitzware.brazukacarclean.model.RoleModel;
import com.blitzware.brazukacarclean.repository.RoleRepository;

@Component
public class BrazukaApplicationInit implements ApplicationRunner {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (roleRepository.count() <= 0) {
			List<RoleModel> roles = new ArrayList<>();
			List<String> rolesName = Arrays.asList(APIConstants.ROLE_ADMIN, APIConstants.ROLE_USER, APIConstants.ROLE_COMPANY);
			for (int i = 0; i < rolesName.size(); i++) {
				roles.add(new RoleModel(null,rolesName.get(i)));
			}
			roleRepository.saveAll(roles);
		}
	}
}
