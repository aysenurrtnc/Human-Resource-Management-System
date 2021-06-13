package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.BusinessRules;
import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;	
	}
	

	@Override
	public DataResult<List<User>> getById(int id) {
		return new SuccessDataResult<List<User>>(this.userDao.getById(id));
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		return new SuccessDataResult<List<User>>(this.userDao.getByEmail(email));
	}


	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "users was listed");
	}


	@Override
	public Result add(User user) {
		Result result = BusinessRules.run(nullControl(user), eMailFormat(user.getEmail()));
		if (result.isSuccess()) {
			this.userDao.save(user);
			return new SuccessResult("user was added");
		}
		
		return new SuccessResult();
	}

	private Result nullControl(User user) {
		if (Objects.isNull(user.getId()) || Objects.isNull(user.getEmail())|| Objects.isNull(user.getPassword())) {
			return new ErrorResult("These fields cannot be left blank.");
		}
		return new SuccessResult();
	}
	
	public static final Pattern validEmail = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$",
			Pattern.CASE_INSENSITIVE);

	private Result eMailFormat(String email) {
		if (!validEmail.matcher(email).find()) {
			return new ErrorResult("Enter a valid email address");
		}
		return new SuccessResult();
	}
	
	
	
}
