package com.exam.controller;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserResponse;
import com.exam.model.UserRole;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.UserResponseService;
import com.exam.service.UserService;
//import com.example.entities.Users;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserResponseService userResService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {


        user.setProfile("default.png");
        //encoding password with bcryptpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);


        return this.userService.createUser(user, roles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }
    
    @PutMapping("/")
    public User update(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    


    @GetMapping("/alluserdetails")
	public ResponseEntity<?> getAllUserdetails(){
			List<User> userdetails=userService.getAllUserdetails();
			return new ResponseEntity<List<User>>(userdetails,HttpStatus.OK);
		
	}
    
    @GetMapping("/alltakensurveydetails")
	public ResponseEntity<?> getAllTakenSurveyDetails(){
			List<UserResponse> usersurveydetails=userService.getAllTakenSurveyDetails();
			return new ResponseEntity<List<UserResponse>>(usersurveydetails,HttpStatus.OK);
		
	}
    
    
    @GetMapping("/takensurvey/{username}")
    public ResponseEntity<?> getUserSurveyTaken(@PathVariable("username") String username) {
    	List<UserResponse> usertakensurveydetails=userService.getUserSurveyTaken(username);
    	return new ResponseEntity<List<UserResponse>>(usertakensurveydetails,HttpStatus.OK);
//        return this.userService.getUserSurveyTaken(username);
    }

    @DeleteMapping("/takensurvey/{sid}")
    public void deleteTakenSurvey(@PathVariable("sid") Long sid) {
        this.userResService.deleteTakenSurvey(sid);
    }
    



    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


}
