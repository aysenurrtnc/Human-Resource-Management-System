package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	
	Result add(CandidateCv candidateCv);
	DataResult<List<CandidateCv>> getByCandidateId(int candidateId);
	
	
	
	

}
