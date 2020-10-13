package com.avla.pruebatecnicafront.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
	
	private Integer id;
	private String task_name;
	private String task_type;
	private String description;
	private Integer duration_hours;
	private String start_date;
	private String end_date;	
	private boolean mark;
	private boolean process;
	
}
