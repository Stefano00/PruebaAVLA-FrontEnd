package com.avla.pruebatecnicafront.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avla.pruebatecnicafront.dto.UserDTO;
import com.avla.pruebatecnicafront.model.Task;


@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Task> findAll() {
		HttpHeaders headers = new HttpHeaders();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());
		HttpEntity<UserDTO> request = new HttpEntity<>(headers);

		ResponseEntity<List<Task>> response = restTemplate.exchange("http://localhost:5000/api/v1/tasks/all",
				HttpMethod.GET, request, new ParameterizedTypeReference<List<Task>>() {
				});
		return response.getBody();
	}

	@Override
	public void createTask(Task task) {
		
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());

		HttpEntity<Task> request = new HttpEntity<>(task, headers);
		System.out.println(request.toString());
		 ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:5000/api/v1/tasks/create", request, String.class);
		
		// check response
		if (response.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Post Created");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}
	
	}

	@Override
	public void editTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
