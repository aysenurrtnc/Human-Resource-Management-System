package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateSchool;
import com.kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

public interface CandidateSchoolService {
	
	DataResult<List<CandidateSchool>> getAll();
	
	DataResult<List<CandidateSchool>> findByCandidateId(int id);
	
	DataResult<List<CandidateSchool>> orderedCandidateCvSchools(int id);
	
	Result add(CandidateSchoolDto school);
	
	DataResult<List<CandidateSchool>> findByCandidateCvId(int id);

	
	

}
