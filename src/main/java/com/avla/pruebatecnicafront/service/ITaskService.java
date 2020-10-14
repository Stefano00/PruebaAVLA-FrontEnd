package com.avla.pruebatecnicafront.service;

import java.util.List;

import com.avla.pruebatecnicafront.model.Task;

public interface ITaskService {
	
	List<Task> findAll();
	void createTask(Task task);
	void editTask(Task task);
	List<Task> findById(Integer id);

}
