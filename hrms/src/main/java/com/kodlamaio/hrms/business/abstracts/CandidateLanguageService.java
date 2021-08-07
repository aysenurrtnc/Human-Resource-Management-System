package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateLanguage;
import com.kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

public interface CandidateLanguageService {
	
	DataResult<List<CandidateLanguage>> getAll();
	
	Result add(CandidateLanguageDto language);
	
	DataResult<List<CandidateLanguage>> findByCandidateCvId(int id);
	
	
	
	

}
