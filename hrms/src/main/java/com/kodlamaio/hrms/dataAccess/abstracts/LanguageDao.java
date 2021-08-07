package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.hrms.entities.concretes.CandidateLanguage;
import com.kodlamaio.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	
	@Query(value="select * from candidates_lang where candidates_cv_id =:cvId and languages_id=:langId  ",nativeQuery=true)
	CandidateLanguage getByCandidateCvId(int cvId); 

}
