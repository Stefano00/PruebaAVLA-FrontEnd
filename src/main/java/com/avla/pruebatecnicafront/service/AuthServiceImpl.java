package com.avla.pruebatecnicafront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avla.pruebatecnicafront.dto.UserDTO;


@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private RestTemplate restTemplate;


	@Override
	public ResponseEntity signin(String usernames, String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(usernames);
		userDTO.setPassword(password);
		HttpEntity<UserDTO> request = new HttpEntity<>(userDTO);
		return restTemplate.postForEntity("http://localhost:5000/api/v1/signIn", request, String.class);
		
	}

}
