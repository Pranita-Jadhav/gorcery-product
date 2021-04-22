package com.mindbowser.grocery.store.management.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class LoginDto {
	@Email(message = "please enter valid email")
	private String email;
	@NotEmpty(message = "please enter a valid password")
	private String password;
}
