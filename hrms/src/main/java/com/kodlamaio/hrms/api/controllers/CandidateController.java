package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;


@RestController
@Controller("/api/candidates")

public class CandidateController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
		
	}
	
	@GetMapping("/getall")
	public Result getAll() {
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	
	
}
