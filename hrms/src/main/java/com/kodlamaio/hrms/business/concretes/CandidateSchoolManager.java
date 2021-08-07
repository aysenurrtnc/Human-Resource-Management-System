package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import com.kodlamaio.hrms.core.utilities.dtoTransfers.DtoService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import com.kodlamaio.hrms.entities.concretes.CandidateSchool;
import com.kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{
	private CandidateSchoolDao candidateSchoolDao;
	private CandidateCvDao candidateCvDao;
	private DtoService dtoService;
	
	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao, CandidateCvDao candidateCvDao,
			DtoService dtoService) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
		this.candidateCvDao = candidateCvDao;
		this.dtoService = dtoService;
	}

	@Override
	public DataResult<List<CandidateSchool>> getAll() {
		return new SuccessDataResult<List<CandidateSchool>>
		(this.candidateSchoolDao.findAll(), "iş arayanın eğitim bilgisi başarıyla listelendi.");
	}

	@Override
	public DataResult<List<CandidateSchool>> findByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateSchool>>
		(this.candidateSchoolDao.findAll(), "iş arayanın eğitim bilgisi başarıyla listelendi.");
	}

	@Override
	public DataResult<List<CandidateSchool>> orderedCandidateCvSchools(int id) {
		if(!this.candidateCvDao.existsById(id)) {
			return new ErrorDataResult<>("Cv bulunamadı");
		}
		return new SuccessDataResult<List<CandidateSchool>>
		(this.candidateSchoolDao.getSchoolsOrderByGraduationDateDesc(id),
				"İş arayanın okul bilgileri listelendi");
	}

	@Override
	public Result add(CandidateSchoolDto school) {
		this.candidateSchoolDao.save((CandidateSchool)
		dtoService.dtoClassConverter(school, CandidateSchool.class));
		return new SuccessResult("başarılı");
		}

	@Override
	public DataResult<List<CandidateSchool>> findByCandidateCvId(int id) {
		 return new SuccessDataResult<List<CandidateSchool>>
	        (this.candidateSchoolDao.getByCandidateCvId(id),"Başarılı");
	}
	
	
	
	

}
