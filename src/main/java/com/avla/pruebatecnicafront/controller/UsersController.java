package com.avla.pruebatecnicafront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping()
public class UsersController {

	@GetMapping("/users")
	public String findAll() {
		return "users";
	}
}
