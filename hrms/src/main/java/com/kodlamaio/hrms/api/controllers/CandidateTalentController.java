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

import com.kodlamaio.hrms.business.abstracts.CandidateTalentService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateTalent;
import com.kodlamaio.hrms.entities.dtos.CandidateTalentDto;

@RestController
@RequestMapping("/api/candidatetalents")
@CrossOrigin

public class CandidateTalentController {
	
private CandidateTalentService candidateTalentService;
	
	@Autowired
	public CandidateTalentController(CandidateTalentService candidateTalentService) {
		this.candidateTalentService = candidateTalentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateTalent>> getAll(){
		return this.candidateTalentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateTalentDto talent){
		return this.candidateTalentService.add(talent);
	}
	
	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateTalent>> findByCandidateId(@RequestParam int id) {
		
		return this.candidateTalentService.findByCandidateCvId(id);
	}
	
	
	

}
