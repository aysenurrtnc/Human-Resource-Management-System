package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer>{
	
	List<CandidateJobExperience> getById(int id);
	
	List<CandidateJobExperience> getByCandidateCvId(int id);
	
	@Query("From CandidateJobExperience c where candidates_cv_id =: id ORDER BY exit_date, is_continue DESC")
	List<CandidateJobExperience> getJobExperienceOrderByExitDateDesc(int id);
	
	List<CandidateJobExperience> findByCandidateCvId(int id);
	
	
	
	

}
