package com.exam.exam.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.exam.Model.Question;
import com.exam.exam.Model.Quizz;

@Service
public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Question getQuestion(int questionid);
	
	public void deleteQuestion(int questionid);
	
	public Set<Question> getAllQuestion();
	
	public Set<Question> getQuestionOfQuizz(Quizz quizz);
	
	
}
