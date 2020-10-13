package com.avla.pruebatecnicafront.service;

import org.springframework.http.ResponseEntity;

public interface IAuthService {
	

	ResponseEntity signin(String username, String password);
}
