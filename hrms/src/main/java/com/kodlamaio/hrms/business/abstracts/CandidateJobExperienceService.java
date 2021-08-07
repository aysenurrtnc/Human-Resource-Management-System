package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import com.kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

public interface CandidateJobExperienceService {
	
	DataResult<List<CandidateJobExperience>> getAll();
	
	DataResult<List<CandidateJobExperience>> getById(int id);
	
	DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id);
	
	Result add(CandidateJobExperienceDto jobExperience);
	
	DataResult<List<CandidateJobExperience>> findByCandidateCvId(int id);

}
