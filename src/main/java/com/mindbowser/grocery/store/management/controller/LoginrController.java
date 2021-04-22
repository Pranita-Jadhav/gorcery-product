package com.mindbowser.grocery.store.management.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindbowser.grocery.store.management.common.constant.CommonCostant;
import com.mindbowser.grocery.store.management.common.constant.ProductConstant;
import com.mindbowser.grocery.store.management.common.constant.SuperAdminConstant;
import com.mindbowser.grocery.store.management.dto.LoginDto;
import com.mindbowser.grocery.store.management.response.Response;
import com.mindbowser.grocery.store.management.service.LoginService;
import com.mindbowser.grocery.store.management.service.RegistrationServiceImpl;
import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;
import com.mindbowser.grocery.store.management.utility.TokenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@CrossOrigin("*")
@RequestMapping("/home")
public class LoginrController {

	@Autowired
	LoginService loginService;

	@Autowired
	TokenService tokenService;

	@Autowired
	RegistrationServiceImpl registrationService;

	@PostMapping("/login")
	public Response login(@Valid @RequestBody LoginDto loginDto) {
		try {
			SuperAdmin admin = loginService.newRegistration(loginDto);
			if (admin != null) {
				String token = tokenService.createToken(admin.getEmail());

				return new Response<>(SuperAdminConstant.LOGIN_SUCCESSFULLY, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, admin);
			} else {
				return new Response<>(CommonCostant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}

		} catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(CommonCostant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}
	}

	@PostMapping("/register")
	public Response newRegistration(@Valid @RequestBody SuperAdmin superAdmin) {
		try {
			SuperAdmin admin = registrationService.newRegistration(superAdmin);
			if (admin != null) {
				return new Response<>(SuperAdminConstant.REGISTRATION_SUCCESSFULLY, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, admin);
			} else {
				return new Response<>(CommonCostant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}
		}

		catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(CommonCostant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}

	}
}
