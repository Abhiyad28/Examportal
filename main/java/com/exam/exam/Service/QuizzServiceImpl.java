package com.exam.exam.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exam.Model.Quizz;
import com.exam.exam.repository.QuizzRepository;

@Service
public class QuizzServiceImpl implements QuizzService {

	@Autowired
	private QuizzRepository quizzRepository;
	@Override
	public Quizz addQuizz(Quizz quizz) {
		// TODO Auto-generated method stub
		return this.quizzRepository.save(quizz);
	}

	@Override
	public Quizz updateQuizz(Quizz quizz) {
		// TODO Auto-generated method stub
		return this.quizzRepository.save(quizz);
	}

	@Override
	public Quizz getQuizz(int qid) {
		// TODO Auto-generated method stub
		return this.quizzRepository.findById(qid).get();
	}

	@Override
	public void deleteQuizz(int qid) {
		// TODO Auto-generated method stub
		this.quizzRepository.deleteById(qid);;
	}

	@Override
	public Set<Quizz> getAllQuizz() {
		// TODO Auto-generated method stub
		return (Set<Quizz>) this.quizzRepository.findAll();
	}

}
