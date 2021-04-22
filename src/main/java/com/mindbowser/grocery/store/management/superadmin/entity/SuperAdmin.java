package com.mindbowser.grocery.store.management.superadmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

@Table(name = "super_admin", schema = "grocery_management")
public class SuperAdmin {

	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull(message = "Please enter name !")
	@Size(min = 2, message = "Name should contain atleast 2 letters !")
	@Pattern(regexp = "^[_A-z]*((-|\\s)*[_A-z])*$", message = "Please enter valid name !")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Please enter name !")
	@Size(min = 2, message = "Name should contain atleast 2 letters !")
	@Pattern(regexp = "^[_A-z]*((-|\\s)*[_A-z])*$", message = "Please enter valid name !")
	@Column(name = "lasts_name")
	private String lastName;

	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Please enter a valid email.!")
	@Column(name = "email")
	private String email;

	@NotNull(message = "Please enter mobile number !")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Please enter a valid phone number.")
	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "DOB")
	private String DOR;

	@Column(name = "company_name")
	private String companyName;

}
