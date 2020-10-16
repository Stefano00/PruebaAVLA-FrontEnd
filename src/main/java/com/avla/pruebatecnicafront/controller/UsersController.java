package com.avla.pruebatecnicafront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avla.pruebatecnicafront.model.Role;
import com.avla.pruebatecnicafront.model.User;
import com.avla.pruebatecnicafront.service.IUserService;
import com.avla.pruebatecnicafront.service.IUserTaskService;

@Controller
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

	
	@Autowired
	IUserService userService;
	
	@Autowired
	IUserTaskService userTaskService;
	
	@GetMapping("/all")
	public String findAll(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "users";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		model.addAttribute("roles", Role.values());
				
		return "createUser";
	}
	
	@PostMapping("/create")
	public String postCreate(@ModelAttribute User user,Model model) {
		userService.save(user);
		model.addAttribute("userList", userService.findAll());
		return "users";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		
		userService.delete(id);	
		model.addAttribute("userList", userService.findAll());
		return "users";
	}
}
