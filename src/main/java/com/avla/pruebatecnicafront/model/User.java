package com.avla.pruebatecnicafront.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String email;
	private Role roles;
	/*private List<Role> role;*/
	
/*
	private List<Task> id_task;*/


}
