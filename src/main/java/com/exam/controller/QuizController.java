package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid) {

        return this.quizService.getQuiz(qid);
    }

    //delete the quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }   

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }

    //get active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
//    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////    	Calendar cDate = Calendar.getInstance();
//    	Date cDate =new Date(System.currentTimeMillis());
//    	System.out.println("Datejdd  = "+dateFormat.format(cDate.getTime()));
//    	Quiz quiz=new Quiz();
//    	
//    	

////    	if(cDate.compareTo(quiz.getStartDate())>0) {
////    		System.out.println("cfdsff");
////    	}
    	
 
        return this.quizService.getActiveQuizzes();
        
    }

    

	//get active quizzes of category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }




}
