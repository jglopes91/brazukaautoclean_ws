package com.blitzware.brazukacarclean.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzware.brazukacarclean.constants.APIConstants;
import com.blitzware.brazukacarclean.model.UserModel;
import com.blitzware.brazukacarclean.service.UserService;

@RestController
@Controller
@RequestMapping(value = APIConstants.USER_URL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/register")
	public ResponseEntity<UserModel> newUser(@Valid @RequestBody UserModel dto) {
		return new ResponseEntity<>(userService.newUser(dto), HttpStatus.CREATED);
	}

}
