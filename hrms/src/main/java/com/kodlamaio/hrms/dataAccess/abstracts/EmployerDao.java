package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	List<Employer> getByEmail(String email);
	//*
	boolean existsById(int id);


}
