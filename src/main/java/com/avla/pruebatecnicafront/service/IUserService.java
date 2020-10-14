package com.avla.pruebatecnicafront.service;

import java.util.List;

import com.avla.pruebatecnicafront.model.User;

public interface IUserService {
	
	List<User> findAll();
	void save(User user);

}
