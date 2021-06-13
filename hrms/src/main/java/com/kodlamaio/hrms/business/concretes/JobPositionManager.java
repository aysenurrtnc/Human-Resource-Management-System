package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPositionService;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

@Service //bu class projede Service görevi görecek diye Spring'e bilgi veriyor.

public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired //injection'ı yapar
	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.jobPositionDao = positionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = new ErrorResult("Job Position could not be added to the system!");
		if (positionIsItUsed(jobPosition.getPosition())) {
			this.jobPositionDao.save(jobPosition);
			result = new SuccessResult("Job Position successfully added to the system!");
		}
		return result;
	}

	@Override
	public Result update(JobPosition jobPosition) {
		Result result = new ErrorResult("Job position ");
		if (positionIsItUsed(jobPosition.getPosition())) {
			this.jobPositionDao.save(jobPosition);
			result = new SuccessResult("Job Position successfully uptated");
		}
		return result;
	}
	

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("Job Position successfully deleted");
	}
	
	
	
	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getPosition() == positionName) {
				result = false;
			}
		}
		return result;
	}





	
}
