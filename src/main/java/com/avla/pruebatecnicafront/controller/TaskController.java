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

import com.avla.pruebatecnicafront.model.Task;
import com.avla.pruebatecnicafront.service.ITaskService;

@Controller
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	ITaskService taskService;
	
	@GetMapping("/all")
	public String findAll(Model model) {
		
		model.addAttribute("taskList", taskService.findAll());
		return "task";
	}
	
	@PostMapping("/create")
	public String postCreate(@ModelAttribute Task task) {
		taskService.createTask(task);
		return "createTask";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		
		return "createTask";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("taskId", taskService.findById(id));
		return "taskId";
	}
}
