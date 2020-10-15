package com.avla.pruebatecnicafront.service;

import java.util.List;

import com.avla.pruebatecnicafront.model.Task;

public interface ITaskService {
	
	List<Task> findAll();
	void createTask(Task task);
	void editTask(Task task);
	Task findById(Integer id);
	List<Task> findTaskByUser(Integer id);
	void delete(Task task);


}
