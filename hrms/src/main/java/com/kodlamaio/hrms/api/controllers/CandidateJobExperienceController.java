package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateJobExperience;
import com.kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

@RestController
@RequestMapping("/api/candidateexperiences")
@CrossOrigin

public class CandidateJobExperienceController {

	private CandidateJobExperienceService candidateJobExperienceService;
	
	@Autowired
	public CandidateJobExperienceController(CandidateJobExperienceService candidateJobExperienceService) {
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateJobExperience>> getAll(){
		return this.candidateJobExperienceService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<List<CandidateJobExperience>> getbyid(@RequestParam int id) {
		
		return this.candidateJobExperienceService.getById(id);
	}
	
	@GetMapping("/getorderedcandidatecvjobexperience")
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvSchools(@RequestParam int id){
		return this.candidateJobExperienceService.orderedCandidateCvJobExperience(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobExperienceDto jobexp) {
		return this.candidateJobExperienceService.add(jobexp);
	}
	
	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateJobExperience>> findByCandidateId(@RequestParam int id) {
		
		return this.candidateJobExperienceService.findByCandidateCvId(id);
	}
	
}
