package com.blitzware.brazukacarclean.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.blitzware.brazukacarclean.constants.APIConstants;
import com.blitzware.brazukacarclean.model.CompanyModel;
import com.blitzware.brazukacarclean.model.RoleModel;
import com.blitzware.brazukacarclean.model.ServiceItemModel;
import com.blitzware.brazukacarclean.repository.CompanyRepository;
import com.blitzware.brazukacarclean.repository.RoleRepository;
import com.blitzware.brazukacarclean.repository.ServiceItemRepository;
import com.blitzware.brazukacarclean.security.UserPrincipal;

@Service
public class CompanyService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	ServiceItemRepository serviceItemRepository;

	public CompanyModel newCompany(CompanyModel dto) {
		dto.getLogin()
				.setRole(roleRepository.findByRoleName(APIConstants.ROLE_COMPANY).orElse(new RoleModel(null, null)));
		dto.getLogin().setIsEnable(false);
		return companyRepository.save(dto);
	}

	@Transactional
	public ServiceItemModel addnewService(ServiceItemModel dto) {
		CompanyModel company = getCompanyByToken();
		ServiceItemModel model = serviceItemRepository.save(dto);
		company.getServices().add(model);
		companyRepository.save(company);
		return model;
	}

	public List<ServiceItemModel> getCompanyServiceByToken() {
		return (List<ServiceItemModel>) getCompanyByToken().getServices().parallelStream()
				.filter(item -> item.getIsVisible() == true).collect(Collectors.toList());
	}

	public List<ServiceItemModel> getCompanyServicesByIdCompany(Long id) {
		return companyRepository.findById(id).get().getServices();
	}

	public CompanyModel getCompanyByToken() {
		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return companyRepository.findByEmail(user.getUsername());
	}

	public Void deleteById(Long id) {
		boolean isAlowedToDelete = false;
		List<ServiceItemModel> services = getCompanyByToken().getServices();
		for (int i = 0; i < services.size(); i++) {
			if (services.get(i).getId() == id) {
				isAlowedToDelete = true;
			}
		}
		if (isAlowedToDelete) {
			ServiceItemModel item = serviceItemRepository.findById(id).get();
			item.setIsVisible(false);
			serviceItemRepository.save(item);
		}
		return null;
	}

}
