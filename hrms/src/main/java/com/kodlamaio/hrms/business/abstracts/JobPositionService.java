package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	
	List<JobPosition> getAll();
	public Result add(JobPosition jobPosition);
	public Result update(JobPosition jobPosition);
	public Result delete(JobPosition jobPosition);
}
