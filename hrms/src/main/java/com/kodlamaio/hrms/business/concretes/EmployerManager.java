package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.BusinessRules;
import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.abstracts.VerificationCodeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"employers was listed");
	}

	@Override
	public Result add(Employer employer) {
		Result result=BusinessRules.run(nullControl(employer),webAdressControl(employer.getWebAddress(),employer.getEmail()),existEmail(employer.getEmail()),realPhoneNumber(employer.getPhoneNumber()));
		if(result.isSuccess()) {
			this.employerDao.save(employer);
			verificationCodeService.sendVerificationCode(employer.getEmail());
			return new SuccessResult("The employer has been added to the system. A verification code has been sent to the e-mail address.");
		}
		return result;
	}

	@Override
	public DataResult<List<Employer>> getByEmail(String email) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmail(email));
	}
	
	private Result nullControl(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getId()) || Objects.isNull(employer.getPassword()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getWebAddress())) {
			return new ErrorResult("These fields cannot be left blank.");
		}
		return new SuccessResult();
	}
	

private Result existEmail(String email) {
	if (this.employerDao.getByEmail(email).stream().count() !=0) {
		return new ErrorResult("this email was already registered");
	}
	return new SuccessResult();
}

private Result webAdressControl(String webAddress, String email) {
	String emailSplit= email.split("@")[1];
	
	if (!webAddress.contains(emailSplit)) {
		return new ErrorResult("email must have the domain of the website..");
	}
	return new SuccessResult();
}
private Result realPhoneNumber(String phoneNumber) {
	String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	Pattern pattern=Pattern.compile(patterns);
	Matcher matcher=pattern.matcher(phoneNumber);
	if(!matcher.matches()) {
		return new ErrorResult("Invalid telephone number");
	}
	return new SuccessResult();
	
}
	

	
	
	
	

	
	
	
}

