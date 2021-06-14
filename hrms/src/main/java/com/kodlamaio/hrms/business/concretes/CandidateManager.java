package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.BusinessRules;
import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import com.kodlamaio.hrms.entities.concretes.Candidate;



@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
    public CandidateManager( CandidateDao candidateDao) {
    	super();
    	this.candidateDao = candidateDao;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(), "candidates was listed");
	}

	@Override
	public Result add(Candidate candidate) {
		Result result=BusinessRules.run(CheckIdentityNumber(candidate),
				nullControl(candidate),
				Tc(candidate.getIdentificationNumber()),
			    eMail(candidate.getEmail()),
			    eMailFormat(candidate.getEmail()));
if (result.isSuccess()) {
			
			this.candidateDao.save(candidate);
			return new SuccessResult(candidate.getFirstName()+" "+candidate.getLastName()+ " candidate was added");
		}
		
		return result;
		
	}

	private Result CheckIdentityNumber(Candidate candidate) {
		if(candidate.getIdentificationNumber().length()!=11) {
			return new ErrorResult("Tc must be 11 digits");
		}
		return new SuccessResult();
	}

	private Result nullControl(Candidate candidate) {
	if(Objects.isNull(candidate.getBirthYear())
			||  Objects.isNull(candidate.getEmail()) 
			|| Objects.isNull(candidate.getId()) 
			|| Objects.isNull(candidate.getFirstName()) 
			|| Objects.isNull(candidate.getIdentificationNumber())
			|| Objects.isNull(candidate.getLastName())
			|| Objects.isNull(candidate.getPassword())) {

		return new ErrorResult("These fields cannot be left blank!");
	}
	return new SuccessResult();
	}
		
	private Result Tc(String identitificationNumber) {
	if(candidateDao.getByIdentificationNumber(identitificationNumber).stream().count()!=0) {
		return new ErrorResult("This Tc was already used!");
	}
	return new SuccessResult();

	}

	private Result eMail(String email) {
	if(candidateDao.getByEmail(email).stream().count()!=0) {
		return new ErrorResult("this email was already registered");
	}
	return new SuccessResult();
	}
	public static final Pattern validEmail = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
			Pattern.CASE_INSENSITIVE);

	private Result eMailFormat(String email) {
		if(!validEmail.matcher(email).find()) {
			return new ErrorResult("Invalid email address");
		}
		return new SuccessResult();
	}
	


}
