package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	List<User> getById(int id);
	List<User> getByEmail(String email);
}
