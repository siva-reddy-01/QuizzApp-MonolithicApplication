package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		
		return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new  ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
		return new ResponseEntity<>(questiondao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	
	public ResponseEntity<String> addQuestion(Question question) {
		
		questiondao.save(question);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
}
