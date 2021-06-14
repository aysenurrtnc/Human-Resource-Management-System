package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
		
	}
	
	@GetMapping("/getall")
	DataResult<List<City>> getAll() {
		return cityService.getAll();
	}
	
	

}
