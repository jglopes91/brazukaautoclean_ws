package com.blitzware.brazukacarclean.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzware.brazukacarclean.constants.APIConstants;
import com.blitzware.brazukacarclean.model.CompanyModel;
import com.blitzware.brazukacarclean.model.ServiceItemModel;
import com.blitzware.brazukacarclean.service.CompanyService;

@RestController
@Controller
@RequestMapping(value = APIConstants.COMPANY_URL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
	@Autowired
	CompanyService companyService;

	@PostMapping(value = "/register")
	public ResponseEntity<CompanyModel> newUser(@Valid @RequestBody CompanyModel dto) {
		return new ResponseEntity<>(companyService.newCompany(dto), HttpStatus.CREATED);
	}

	@Secured("ROLE_COMPANY")
	@GetMapping(value = "/find")
	public ResponseEntity<CompanyModel> getUserInformation() {
		return new ResponseEntity<>(companyService.getCompanyByToken(), HttpStatus.OK);
	}

	@Secured("ROLE_USER")
	@GetMapping(value = "/service/{idCompany}")
	public ResponseEntity<List<ServiceItemModel>> getServicesById(@PathVariable("idCompany") Long idCompany) {
		return new ResponseEntity<>(companyService.getCompanyServicesByIdCompany(idCompany), HttpStatus.OK);
	}

	@Secured("ROLE_COMPANY")
	@GetMapping(value = "/service/me")
	public ResponseEntity<List<ServiceItemModel>> getServicesByCompanyToken() {
		return new ResponseEntity<>(companyService.getCompanyServiceByToken(), HttpStatus.OK);
	}

	@Secured("ROLE_COMPANY")
	@PostMapping(value = "/service")
	public ResponseEntity<ServiceItemModel> saveNewService(@Valid @RequestBody ServiceItemModel dto) {
		return new ResponseEntity<>(companyService.addnewService(dto), HttpStatus.CREATED);
	}

	@Secured("ROLE_COMPANY")
	@DeleteMapping(value = "/service/{idService}")
	public ResponseEntity<Void> deleteByIdService(@PathVariable("idService") Long idService) {
		return new ResponseEntity<>(companyService.deleteById(idService), HttpStatus.NO_CONTENT);
	}
}
