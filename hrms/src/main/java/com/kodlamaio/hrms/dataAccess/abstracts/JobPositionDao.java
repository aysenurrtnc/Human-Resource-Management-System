package com.kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{  //CRUD operasyonları burda hazır

	JobPosition getByPosition(String position);
}
