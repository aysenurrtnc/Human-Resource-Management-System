package com.kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementDto {
	
	@JsonIgnore
	private int id;
	
	private int employerId;
	
	private int jobPositionId;

	private int cityId;
	
	private String description;
	
	private int numberOfOpenPosition;
	
	private Double minSalary;
	
	private Double maxSalary;
	
	private boolean isActive;
	
	private LocalDateTime appealExpirationDate;
	
	private LocalDateTime createdDate=LocalDateTime.now();

}
