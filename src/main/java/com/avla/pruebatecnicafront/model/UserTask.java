package com.avla.pruebatecnicafront.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTask {
	
	private Integer id;
	private Integer id_user;
	private Integer id_task;

}
