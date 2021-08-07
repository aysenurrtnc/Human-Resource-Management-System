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

import com.kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateSchool;
import com.kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

@RestController
@RequestMapping("/api/candidateschools")
@CrossOrigin

public class CandidateSchoolController {

	private CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidateSchoolController(CandidateSchoolService candidateSchoolService) {
		super();
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateSchool>> getAll(){
		return this.candidateSchoolService.getAll();
	}
	
	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateSchool>> findByCandidateId(@RequestParam int id) {
	
		return this.candidateSchoolService.findByCandidateId(id);
	}
	
	@GetMapping("/getorderedcandidatecvschools")
	public DataResult<List<CandidateSchool>> orderedCandidateCvSchools(@RequestParam int id){
		return this.candidateSchoolService.orderedCandidateCvSchools(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDto school) {
		
		return this.candidateSchoolService.add(school);
	}
	
	
	
	
}
