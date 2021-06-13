package com.kodlamaio.hrms.core.abstracts;

import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	boolean checkIfRealPerson(Candidate candidate);

}
