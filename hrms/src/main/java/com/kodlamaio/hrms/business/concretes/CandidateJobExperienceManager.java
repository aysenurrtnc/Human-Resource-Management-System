package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import com.kodlamaio.hrms.core.utilities.dtoTransfers.DtoService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import com.kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import com.kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {
	
	private CandidateJobExperienceDao candidateJobExperienceDao;
	private CandidateCvDao candidateCvDao;
	private DtoService dtoService;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,
			CandidateCvDao candidateCvDao, DtoService dtoService) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;
		this.dtoService = dtoService;
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.findAll(), "adayın iş tecrübeleri listelendi.");
	}

	@Override
	public DataResult<List<CandidateJobExperience>> getById(int id) {
		
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.getById(id), "başarılı.");
		
	}

	@Override
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id) {
		if(!this.candidateCvDao.existsById(id)) {
			return new ErrorDataResult<>("Cv bulunamadı");
		}
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.getJobExperienceOrderByExitDateDesc(id),
				"başarılı Şekilde İş arayanın tecrübe bilgileri listelendi");
	}

	@Override
	public Result add(CandidateJobExperienceDto jobExperience) {
		this.candidateJobExperienceDao.save((CandidateJobExperience) 
				this.dtoService.dtoClassConverter(jobExperience, CandidateJobExperience.class));
		return new SuccessResult("başarılı");
	}

	@Override
	public DataResult<List<CandidateJobExperience>> findByCandidateCvId(int id) {
		return new SuccessDataResult<List<CandidateJobExperience>>
        (this.candidateJobExperienceDao.findByCandidateCvId(id), "başarılı");
		
	}
	
	
	
	

}
