package com.avla.pruebatecnicafront.service;

import java.util.List;
import java.util.Map;

import com.avla.pruebatecnicafront.model.User;

public interface IUserService {
	
	List<User> findAll();
	void save(User user);
	Map<Integer, String> taskUserId();
	User findById(Integer id);
	void delete(Integer id);

}
