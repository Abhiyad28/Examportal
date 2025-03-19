package com.exam.exam.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quizz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qid;
	
	private String title;
	
	@Column(length = 50000)
	private String description;
	
	private int maxMarks;
	
	private String numberofQuestion;
	
	private boolean enable=false;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "quiz")
	@JsonIgnore
	private Set<Question> questions=new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	@JoinColumn
	private Category category;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumberofQuestion() {
		return numberofQuestion;
	}

	public void setNumberofQuestion(String numberofQuestion) {
		this.numberofQuestion = numberofQuestion;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Quizz(int qid, String title, String description, int maxMarks, String numberofQuestion, boolean enable,
			Set<Question> questions, Category category) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberofQuestion = numberofQuestion;
		this.enable = enable;
		this.questions = questions;
		this.category = category;
	}

	public Quizz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quizz [qid=" + qid + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", numberofQuestion=" + numberofQuestion + ", enable=" + enable + ", questions=" + questions
				+ ", category=" + category + "]";
	}
	
	
}
