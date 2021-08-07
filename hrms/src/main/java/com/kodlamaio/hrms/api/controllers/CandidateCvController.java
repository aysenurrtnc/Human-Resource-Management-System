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

import com.kodlamaio.hrms.business.abstracts.CandidateCvService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateCv;


@RestController
@RequestMapping("api/cv")
@CrossOrigin

public class CandidateCvController {

	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@GetMapping("/getbycandidateid")
	public DataResult<List<CandidateCv>> getByCandidateId(@RequestParam int candidateId) {
		return this.candidateCvService.getByCandidateId(candidateId);
	}

	
	
}
