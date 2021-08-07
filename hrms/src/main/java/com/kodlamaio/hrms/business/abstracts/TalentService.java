package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Talent;

public interface TalentService {
	
	DataResult<List<Talent>> getAll();

}
