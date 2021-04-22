package com.mindbowser.grocery.store.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindbowser.grocery.store.management.response.Response;
import com.mindbowser.grocery.store.management.service.RegistrationServiceImpl;
import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")

@RequestMapping("/home")
public class RegistrationController {
	
	@Autowired
	RegistrationServiceImpl registrationService;
	
//	@PostMapping("/register")
//	public Response newRegistration(@Valid @RequestBody SuperAdmin superAdmin) {
//		System.out.println("response");
//		registrationService.newRegistration(superAdmin);
//		return null;
//	}
}
