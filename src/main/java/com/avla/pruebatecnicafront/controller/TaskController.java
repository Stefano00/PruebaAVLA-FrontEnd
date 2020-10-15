package com.avla.pruebatecnicafront.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avla.pruebatecnicafront.model.Task;
import com.avla.pruebatecnicafront.model.UserTask;
import com.avla.pruebatecnicafront.service.ITaskService;
import com.avla.pruebatecnicafront.service.IUserService;
import com.avla.pruebatecnicafront.service.IUserTaskService;

@Controller
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	IUserTaskService userTaskService;
	
	@Autowired
	ITaskService taskService;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/all")
	public String findAll(Model model) {
		
		model.addAttribute("taskList", taskService.findAll());
		model.addAttribute("userList", userService.findAll());
		model.addAttribute("taskUserId", userService.taskUserId());
	
	/*	Map<Integer,Integer> userTask = new HashMap<Integer,Integer>();
		userTask=userService.taskUserId();
		for(Integer list : userTask) {
			
		}
		System.out.println(userTask);*/
		return "task";
	}
	
	@PostMapping("/create")
	public String postCreate(@ModelAttribute Task task, @RequestParam Integer id_user, Model model) {
		taskService.createTask(task);
		UserTask userTask = new UserTask();
		userTask.setIdUser(id_user);
		
		List<Task> taskList = new ArrayList<Task>();
		taskList = taskService.findAll();
		userTask.setIdTask(taskList.get(taskList.size()-1).getId());
		userTaskService.save(userTask);
		model.addAttribute("userList", userService.findAll());
		
		return "createTask";
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "createTask";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("taskId", taskService.findTaskByUser(id));
		return "taskId";
	}
	
	@PostMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		taskService.delete(id);
		model.addAttribute("taskList", taskService.findAll());
		model.addAttribute("userList", userService.findAll());
		return "task";
	}
}
