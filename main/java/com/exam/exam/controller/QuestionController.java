package com.exam.exam.controller;

import java.util.Set;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exam.Model.Question;
import com.exam.exam.Model.Quizz;
import com.exam.exam.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping()
	public ResponseEntity<?> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping()
	public ResponseEntity<?> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable int questionId) {
		
		this.questionService.deleteQuestion(questionId);
	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<?> getQuestion(@PathVariable int questionId){
		
		return ResponseEntity.ok(this.questionService.getQuestion(questionId));
	}
	
	@GetMapping()
	public ResponseEntity<Set<Question>> getAllQuestion(){
		
		return ResponseEntity.ok(this.questionService.getAllQuestion());
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<Set<Question>> getQuestionOfQuizz(@PathVariable int qid){
		Quizz quizz=new Quizz();
		quizz.setQid(qid);
		return ResponseEntity.ok(this.questionService.getQuestionOfQuizz(quizz));
	}
}
