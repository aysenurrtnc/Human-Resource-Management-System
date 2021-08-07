package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateTalentService;
import com.kodlamaio.hrms.core.utilities.dtoTransfers.DtoService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateTalentDao;
import com.kodlamaio.hrms.entities.concretes.CandidateTalent;
import com.kodlamaio.hrms.entities.dtos.CandidateTalentDto;


@Service
public class CandidateTalentManager implements CandidateTalentService {
	
	private CandidateTalentDao candidateTalentDao;
	private DtoService dtoService;
	
	@Autowired
	public CandidateTalentManager(CandidateTalentDao candidateTalentDao, DtoService dtoService) {
		super();
		this.candidateTalentDao = candidateTalentDao;
		this.dtoService = dtoService;
	}

	@Override
	public DataResult<List<CandidateTalent>> getAll() {
		return new SuccessDataResult<List<CandidateTalent>>
		(this.candidateTalentDao.findAll(), "iş arayanların yetenekleri başarıyla listelendi.");
	}

	@Override
	public Result add(CandidateTalentDto talent) {
		if(this.candidateTalentDao.existsCvIdAndTalentId(talent.getCvId(), talent.getTalentId()) != null) {
			return new ErrorResult("Daha önceden eklenmiş..");
		}
		else {
			this.candidateTalentDao.save((CandidateTalent) this.dtoService.dtoClassConverter
					(talent, CandidateTalent.class));
			return new SuccessResult("başarılı..");
		}
	}

	@Override
	public DataResult<List<CandidateTalent>> findByCandidateCvId(int id) {
		 return new SuccessDataResult<List<CandidateTalent>>
	        (this.candidateTalentDao.findByCandidateCvId(id),"Başarılı");
	}
	
	
	
	

}
