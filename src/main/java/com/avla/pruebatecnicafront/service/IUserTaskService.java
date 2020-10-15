package com.avla.pruebatecnicafront.service;

import com.avla.pruebatecnicafront.model.UserTask;

public interface IUserTaskService {
	
	void edit (UserTask userTask);
	void save (UserTask userTask);
	UserTask findTaskById(Integer id);

}
