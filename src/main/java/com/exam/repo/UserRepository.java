package com.exam.repo;

import com.exam.model.User;
import com.exam.model.UserResponse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

	public UserResponse findSurveyTakenByUsername(String username);



//	public User updateById(Long userId);

//	public User getAllUserdetails();
}
