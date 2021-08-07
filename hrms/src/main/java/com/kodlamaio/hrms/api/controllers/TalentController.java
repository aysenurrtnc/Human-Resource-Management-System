package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.TalentService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/talents")
@CrossOrigin

public class TalentController {
	
	private TalentService talentService;
	
	@Autowired
	public TalentController(TalentService talentService) {
		this.talentService = talentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Talent>> getAll(){
		return this.talentService.getAll();
	}
	
	

}
