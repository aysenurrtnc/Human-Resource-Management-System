package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateTalent;
import com.kodlamaio.hrms.entities.dtos.CandidateTalentDto;

public interface CandidateTalentService {
	
	DataResult<List<CandidateTalent>> getAll();
	
	Result add(CandidateTalentDto talent);
	
	DataResult<List<CandidateTalent>> findByCandidateCvId(int id);

}
