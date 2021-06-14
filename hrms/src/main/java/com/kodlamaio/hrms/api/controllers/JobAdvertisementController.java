package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
		
	}
	
	@GetMapping("/getallactive")
    public DataResult<List<JobAdvertisement>> findAllByIsActive(){
		
		return this.jobAdvertisementService.findAllByIsActive();
	}
	
	@GetMapping("/getallactivesorteddate")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSortedDate() {
		return this.jobAdvertisementService.findAllByIsActiveSortedDate();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	
	

}
