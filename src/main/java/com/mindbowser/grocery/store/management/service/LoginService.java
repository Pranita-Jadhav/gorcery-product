package com.mindbowser.grocery.store.management.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindbowser.grocery.store.management.dto.LoginDto;
import com.mindbowser.grocery.store.management.repository.SuperAdminRepository;
import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

@Service
public class LoginService {

	@Autowired
	SuperAdminRepository superAdminRepository;

	

	public SuperAdmin newRegistration(@Valid LoginDto loginDto) {
		Optional<SuperAdmin> isSuperAdmin = superAdminRepository.findByEmail(loginDto.getEmail());
		if (isSuperAdmin.isPresent() && loginDto.getPassword() == isSuperAdmin.get().getPassword()) {
			
			return isSuperAdmin.get();
		}

		else {
			return null;
		}

	}

}
