package com.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.exam.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
