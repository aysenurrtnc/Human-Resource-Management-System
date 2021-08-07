package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;
import com.kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	
	DataResult<List<Language>> getAll();

	Result add(LanguageDto lang);
	

	
}
