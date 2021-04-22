package com.mindbowser.grocery.store.management.service;

import javax.validation.Valid;

import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

public interface RegistrationService {
	public SuperAdmin newRegistration(@Valid SuperAdmin superAdmin);
}
