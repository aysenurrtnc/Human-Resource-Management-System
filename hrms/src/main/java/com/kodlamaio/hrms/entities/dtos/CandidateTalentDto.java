package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidateTalentDto {
	
	private int id;
	private String talentName;
	private int talentId;
	private int cvId;
	

}
