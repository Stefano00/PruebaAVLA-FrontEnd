package com.avla.pruebatecnicafront.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.avla.pruebatecnicafront.service.IAuthService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private IAuthService authService;

	@SuppressWarnings("rawtypes")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Map<String, Object> prin = new HashMap<>();
		ResponseEntity tokenSigin = authService.signin(name, pwd);
		prin.put("username", name);
		prin.put("token", tokenSigin.getBody());
		if (tokenSigin.getStatusCode().equals(HttpStatus.OK)) {
			return new UsernamePasswordAuthenticationToken(prin, pwd, new ArrayList<>());
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
