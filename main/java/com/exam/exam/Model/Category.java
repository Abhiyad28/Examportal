package com.exam.exam.Model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	@Column(length = 50000)
	private String description;
	
	private String title;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy = "category")
	@JsonIgnore
	private Set<Quizz> quiz;




	public Category(int cid, String description, String title, Set<Quizz> quiz) {
		super();
		this.cid = cid;
		this.description = description;
		this.title = title;
		this.quiz = quiz;
	}


	public Set<Quizz> getQuiz() {
		return quiz;
	}


	public void setQuiz(Set<Quizz> quiz) {
		this.quiz = quiz;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	

	

	


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Category [cid=" + cid + ", description=" + description + ", title=" + title + ", quiz=" + quiz + "]";
	}


	
	
	
	
}
