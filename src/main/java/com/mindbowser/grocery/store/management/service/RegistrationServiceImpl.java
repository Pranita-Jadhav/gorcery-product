package com.mindbowser.grocery.store.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindbowser.grocery.store.management.repository.SuperAdminRepository;
import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	SuperAdminRepository superAdminRepository;

	public SuperAdmin newRegistration(SuperAdmin superAdmin) {
		String emailId = superAdmin.getEmail();
		Optional<SuperAdmin> newUser = superAdminRepository.findByEmail(emailId);
		if (newUser.isEmpty()) {
			superAdminRepository.save(superAdmin);
			return newUser.get();
		}
		return null;

	}

}
