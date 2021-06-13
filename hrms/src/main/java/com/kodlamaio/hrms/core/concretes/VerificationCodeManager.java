package com.kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.abstracts.VerificationCodeService;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	@Override
	public boolean sendVerificationCode(String email) {
		
		return true;
	}

	

}
