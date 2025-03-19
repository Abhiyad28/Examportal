package com.exam.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.exam.Model.Question;
import com.exam.exam.Model.Quizz;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	Set<Question> findByQuiz(Quizz quizz);

}
