package com.avla.pruebatecnicafront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avla.pruebatecnicafront.model.User;
import com.avla.pruebatecnicafront.service.IUserService;

@Controller
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

	
	@Autowired
	IUserService userService;
	
	@GetMapping("/all")
	public String findAll(Model model) {
		model.addAttribute("userList", userService.findAll());
		System.out.println(userService.findAll());
		return "users";
	}
	
	@GetMapping("/create")
	public String getCreate() {
		
		return "createUser";
	}
	
	@PostMapping("/create")
	public String postCreate(@ModelAttribute User user) {
		userService.save(user);
		return "createUser";
	}
}
