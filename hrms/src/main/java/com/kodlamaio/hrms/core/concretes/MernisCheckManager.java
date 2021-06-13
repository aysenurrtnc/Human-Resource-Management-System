package com.kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.abstracts.MernisCheckService;
import com.kodlamaio.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=true;
		
		try {
			result=client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentificationNumber()), 
					candidate.getFirstName().toUpperCase(),
			        candidate.getLastName().toUpperCase(),
			        candidate.getBirthYear());
		}
		catch(Exception e) {
			e.printStackTrace();
			
	
		}
		return result;
	}
	}


