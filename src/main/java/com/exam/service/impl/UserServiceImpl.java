package com.exam.service.impl;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserResponse;
import com.exam.model.UserRole;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.repo.UserResponseRepository;
import com.exam.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserResponseRepository userResponseRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    
    @Override
    public List<User> getAllUserdetails(){
		return userRepository.findAll();
	}
//	@Override
//	public List<User> getAllUserdetails() {
//		// TODO Auto-generated method stub
//		 return (List<User>) this.userRepository.getAllUserdetails();
//	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public List<UserResponse> getAllTakenSurveyDetails() {
		// TODO Auto-generated method stub
		return userResponseRepository.findAll();
	}

	@Override
	public List<UserResponse> getUserSurveyTaken(String username) {
		// TODO Auto-generated method stub
		return this.userResponseRepository.findTSByUsername(username);
	}

	


	

	


}
