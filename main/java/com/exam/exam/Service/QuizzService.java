package com.exam.exam.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.exam.Model.Quizz;

@Service
public interface QuizzService {

	public Quizz addQuizz(Quizz quizz);
	
	public Quizz updateQuizz(Quizz quizz);
	
	public Quizz getQuizz(int qid);
	
	public void deleteQuizz(int qid);
	
	public Set<Quizz> getAllQuizz();
}
