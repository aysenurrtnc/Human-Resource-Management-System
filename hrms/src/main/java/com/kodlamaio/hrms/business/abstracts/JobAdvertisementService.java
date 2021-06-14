package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll(); //tüm iş ilanları
	DataResult<List<JobAdvertisement>> findAllByIsActive(); //aktif iş ilanları
	DataResult<List<JobAdvertisement>> findAllByIsActiveSortedDate();
	
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	

}
