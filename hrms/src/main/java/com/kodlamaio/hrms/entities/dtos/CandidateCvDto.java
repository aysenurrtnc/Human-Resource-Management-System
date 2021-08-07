package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	
	private int id;
	private int candidateId;
	private String linkedinAddress;
	private String githubAddress;
	private String coverLetter;
	private String avatarUrl;
	private boolean isActive;
	
	

}
