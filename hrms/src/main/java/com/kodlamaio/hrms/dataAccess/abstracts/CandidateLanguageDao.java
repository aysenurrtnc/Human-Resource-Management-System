package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{
	
	CandidateLanguage getById(int id);
	
	List<CandidateLanguage> getByCandidateCvId(int id);
	
	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId LIMIT 1 ",nativeQuery=true)
	CandidateLanguage getByCvId(int cvId);
	
	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId and languages_id=:langId  ",nativeQuery=true)
	CandidateLanguage getByCandidateCvIdAndLanguageId(int cvId, int langId);
	
	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId and languages_id=:langId LIMIT 1 ",nativeQuery=true)
	CandidateLanguage existsCvIdAndLanguageId(int cvId, int langId);
	
	

}
