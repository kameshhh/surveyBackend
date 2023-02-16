package com.exam.service;

import com.exam.model.UserResponse;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

import java.util.Map;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

    public Question get(Long questionsId);

//	public UserResponse addResponse(Map<String, Object> map);

	UserResponse addResponse(UserResponse userres);

}
