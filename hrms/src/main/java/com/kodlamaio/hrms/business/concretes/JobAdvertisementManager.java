package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
	
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.findAll(), "data listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAllByIsActive(true) , "successfully");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSortedDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "appealExpirationDate");
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(sort));
				
	}


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement successfully added ");
		
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("job advertisement successfully deleted");
		
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.saveAndFlush(jobAdvertisement);
		return new SuccessResult("job advertisement successfully updated");
		
	}

	
	

}
