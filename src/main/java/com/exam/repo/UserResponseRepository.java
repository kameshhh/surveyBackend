package com.exam.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.UserResponse;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {

	UserResponse save(String json);

	List<UserResponse> findTSByUsername(String username);
	
//	public void deleteTakenSurveyById(Long sid);


}
