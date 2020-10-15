package com.avla.pruebatecnicafront.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avla.pruebatecnicafront.model.UserTask;

@Service
public class UserTaskServiceImpl implements IUserTaskService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void edit(UserTask userTask) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(UserTask userTask) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());

		HttpEntity<UserTask> request = new HttpEntity<>(userTask, headers);
		System.out.println(request.toString());
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:5000/api/v1/userTask/create", request, String.class);
		

	}

}