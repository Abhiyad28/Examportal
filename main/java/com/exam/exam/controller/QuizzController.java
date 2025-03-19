package com.exam.exam.controller;

import java.util.Set;

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

import com.exam.exam.Model.Quizz;
import com.exam.exam.Service.QuizzService;

@RestController
@RequestMapping("/quizz")
public class QuizzController {
	
	@Autowired
	private QuizzService quizzService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuizz(@RequestBody Quizz quizz){
		
		return ResponseEntity.ok(this.quizzService.addQuizz(quizz));
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuizz(@RequestBody Quizz quizz){
		return ResponseEntity.ok(this.quizzService.updateQuizz(quizz));
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuizz(@PathVariable int qid){
		return ResponseEntity.ok(this.quizzService.getQuizz(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuizz(@PathVariable int qid){
		this.quizzService.deleteQuizz(qid);
	}
	
	@GetMapping()
	public ResponseEntity<Set<Quizz>> getAllQuizz(){
		
		return  ResponseEntity.ok(this.quizzService.getAllQuizz());
	}

}
