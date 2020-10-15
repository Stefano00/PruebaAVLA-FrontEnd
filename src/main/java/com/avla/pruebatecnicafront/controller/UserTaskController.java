package com.avla.pruebatecnicafront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.avla.pruebatecnicafront.model.UserTask;
import com.avla.pruebatecnicafront.service.ITaskService;
import com.avla.pruebatecnicafront.service.IUserService;
import com.avla.pruebatecnicafront.service.IUserTaskService;


@Controller
@CrossOrigin
@RequestMapping("/userTask")
public class UserTaskController {
	
	@Autowired
	IUserTaskService userTaskService;
	
	@Autowired
	ITaskService taskService;
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/create/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("task", taskService.findById(id));
		model.addAttribute("userList", userService.findAll());
		
		return "userTask";
	}
	
	@PostMapping("/edit")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String edit(@ModelAttribute UserTask userTask, Model model) {
		System.out.println("IMPRIMIENDO: " + userTask);
		userTaskService.save(userTask);
		model.addAttribute("taskList", taskService.findAll());
		model.addAttribute("userList", userService.findAll());
		return "task";
	}

}
