package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.dtoTransfers.DtoService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrms.entities.concretes.Language;
import com.kodlamaio.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	private DtoService dtoService;
	
	
	@Autowired
	public LanguageManager(LanguageDao languageDao, DtoService dtoService) {
		super();
		this.languageDao = languageDao;
		this.dtoService = dtoService;
	}


	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>
		(this.languageDao.findAll(), "diller başarıyla listelendi.");
	}


	@Override
	public Result add(LanguageDto lang) {
		this.languageDao.save((Language)
				this.dtoService.dtoClassConverter(lang, Language.class));
		
		return new SuccessResult("başarılı");
	}
	
	
	
	

}
