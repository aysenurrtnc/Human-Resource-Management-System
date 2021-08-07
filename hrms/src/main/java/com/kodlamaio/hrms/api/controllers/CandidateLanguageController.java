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

import com.kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CandidateLanguage;
import com.kodlamaio.hrms.entities.dtos.CandidateLanguageDto;

@RestController
@RequestMapping("api/candidatelanguages")
@CrossOrigin

public class CandidateLanguageController {
	
	private CandidateLanguageService candidateLanguageService;
	
	@Autowired
	public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateLanguage>> getAll(){
		return this.candidateLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguageDto lang) {
		
		return this.candidateLanguageService.add(lang);
	}
	
	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateLanguage>> findByCandidateId(@RequestParam int id) {
		
		return this.candidateLanguageService.findByCandidateCvId(id);
	}
	

}
