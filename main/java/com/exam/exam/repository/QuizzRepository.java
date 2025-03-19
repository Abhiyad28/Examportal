package com.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.exam.Model.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {

}
