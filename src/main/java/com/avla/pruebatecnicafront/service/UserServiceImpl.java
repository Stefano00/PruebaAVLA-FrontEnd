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
import com.avla.pruebatecnicafront.model.User;

@Service
public class UserServiceImpl implements IUserService {

	//String url="http://localhost:5000";
	String url="http://avla-backend.us-east-2.elasticbeanstalk.com";

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<User> findAll() {
		HttpHeaders headers = new HttpHeaders();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());
		HttpEntity<UserDTO> request = new HttpEntity<>(headers);

		ResponseEntity<List<User>> response = restTemplate.exchange(url+"/api/v1/users/all",
				HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>() {
				});
		return response.getBody();
	}

	@Override
	public void save(User user) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());

		HttpEntity<User> request = new HttpEntity<>(user, headers);
		System.out.println(request.toString());
		ResponseEntity<String> response = restTemplate.postForEntity(url+"/api/v1/signUp", request, String.class);
		
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
	public void delete(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());

		HttpEntity<Integer> request = new HttpEntity<>(id, headers);
		System.out.println(request.toString());
		ResponseEntity<String> response = restTemplate.postForEntity(url+"/api/v1/users/delete/"+id, request, String.class);
		
		/*// check response
		if (response.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Post Created");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}*/
	}

	@Override
	public Map<Integer, String> taskUserId() {
		
		HttpHeaders headers = new HttpHeaders();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());
		HttpEntity<UserDTO> request = new HttpEntity<>(headers);

		ResponseEntity<Map<Integer, String>> response = restTemplate.exchange(url+"/api/v1/users/taskUserId",
				HttpMethod.GET, request, new ParameterizedTypeReference<Map<Integer, String>>() {
				});
		return response.getBody();
	}

	@Override
	public User findById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> principal = (Map<String, Object>) auth.getPrincipal();
		headers.setBearerAuth(principal.get("token").toString());
		HttpEntity<UserDTO> request = new HttpEntity<>(headers);

		ResponseEntity<User> response = restTemplate.exchange(url+"/api/v1/tasks/"+id,
				HttpMethod.GET, request, new ParameterizedTypeReference<User>() {
				});
		return response.getBody();
		
	}
	
	

}
