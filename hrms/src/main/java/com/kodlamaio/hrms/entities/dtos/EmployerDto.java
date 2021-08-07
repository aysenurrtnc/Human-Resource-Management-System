package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployerDto {
	
	private int id;
	private String company_name;
	private String webAddress;
	private String phoneNumber;
	

}
