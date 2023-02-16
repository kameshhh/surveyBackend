package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userresponse")
public class UserResponse {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private Long userId;
	  private int attempted;
	  private int correctAnswers;
	  private Long sid;
	  private double marksGot;
	  private String username;
	  private String surveyname;
	public UserResponse(Long id, Long userId, int attempted, int correctAnswers, Long sid, double marksGot,
			String username, String surveyname) {
		super();
		this.id = id;
		this.userId = userId;
		this.attempted = attempted;
		this.correctAnswers = correctAnswers;
		this.sid = sid;
		this.marksGot = marksGot;
		this.username = username;
		this.surveyname = surveyname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSurveyname() {
		return surveyname;
	}
	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}
//	public UserResponse(Long id, Long userId, int attempted, int correctAnswers, int marksGot,Long sid) {
//		super();
//		this.id = id;
//		this.userId = userId;
//		this.attempted = attempted;
//		this.correctAnswers = correctAnswers;
//		this.marksGot = marksGot;
//		this.sid=sid;
//		
//	
//	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setUserResposeId(Long id) {
		this.id =id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getAttempted() {
		return attempted;
	}
	public void setAttempted(int attempted) {
		this.attempted = attempted;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public double getMarksGot() {
		return marksGot;
	}
	public void setMarksGot(double marksGot2) {
		this.marksGot = marksGot2;
	}
	  
	  

}

