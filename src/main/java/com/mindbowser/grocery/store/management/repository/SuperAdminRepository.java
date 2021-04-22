package com.mindbowser.grocery.store.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Integer> {
	
	Optional<SuperAdmin> findByEmail(String email);


}
