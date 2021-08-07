package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.TalentService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TalentDao;
import com.kodlamaio.hrms.entities.concretes.Talent;

@Service
public class TalentManager implements TalentService {
	
	private TalentDao talentDao;
	
	@Autowired
	public TalentManager(TalentDao talentDao) {
		super();
		this.talentDao = talentDao;
	}

	@Override
	public DataResult<List<Talent>> getAll() {
		return new SuccessDataResult<List<Talent>>
		(this.talentDao.findAll(),"Yetenekler başarıyla listelendi");
	}
	
	
	

}
