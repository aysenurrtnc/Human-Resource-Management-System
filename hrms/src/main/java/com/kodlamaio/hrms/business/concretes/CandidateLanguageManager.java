package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import com.kodlamaio.hrms.core.utilities.dtoTransfers.DtoService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import com.kodlamaio.hrms.entities.concretes.CandidateLanguage;
import com.kodlamaio.hrms.entities.dtos.CandidateLanguageDto;



@Service
public class CandidateLanguageManager implements CandidateLanguageService {
	
	private CandidateLanguageDao candidateLanguageDao;
	private DtoService dtoService;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao, DtoService dtoService) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
		this.dtoService = dtoService;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>
		(this.candidateLanguageDao.findAll(), "başarılı");
	}

	@Override
	public Result add(CandidateLanguageDto language) {
		if(this.candidateLanguageDao.existsCvIdAndLanguageId(language.getCandidateCvId(), language.getLanguageId()) != null) {
			return new ErrorResult("Daha önceden eklenmiş");
		}
		this.candidateLanguageDao.save((CandidateLanguage) dtoService.dtoClassConverter(language, CandidateLanguage.class));
		return new SuccessResult("Başarılı");
	}

	@Override
	public DataResult<List<CandidateLanguage>> findByCandidateCvId(int id) {
		return new SuccessDataResult<List<CandidateLanguage>>
		(this.candidateLanguageDao.getByCandidateCvId(id),"Başarılı");
	}
	
	
	
	
	
	
	

}
