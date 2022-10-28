package com.cts.intcdb22jf003.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.intcdb22jf003.pms.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
