package com.exam.exam.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exam.Model.Question;
import com.exam.exam.Model.Quizz;
import com.exam.exam.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	public Question getQuestion(int questionid) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(questionid).get();
	}

	public void deleteQuestion(int questionid) {
		// TODO Auto-generated method stub
		this.questionRepository.deleteById(questionid);
	}

	public Set<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return (Set<Question>) this.questionRepository.findAll();
	}

	public Set<Question> getQuestionOfQuizz(Quizz quizz) {
		// TODO Auto-generated method stub
		return this.questionRepository.findByQuiz(quizz);
	}

}
