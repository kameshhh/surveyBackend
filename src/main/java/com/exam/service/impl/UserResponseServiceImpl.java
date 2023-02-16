package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.exam.repo.UserRepository;
import com.exam.repo.UserResponseRepository;
import com.exam.service.UserResponseService;

@Service
public class UserResponseServiceImpl implements UserResponseService {

    @Autowired
    private UserResponseRepository userRepository;
	
	@Override
	public void deleteTakenSurvey(Long sid) {
		// TODO Auto-generated method stub
		 this.userRepository.deleteById(sid);
		
	}

}
