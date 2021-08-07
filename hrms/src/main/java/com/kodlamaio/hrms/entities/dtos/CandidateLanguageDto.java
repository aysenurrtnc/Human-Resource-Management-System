package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidateLanguageDto {
	
	private int id;
	private int candidateCvId;
	private int languageId;
	private String languagesName;
	private int level;

}
