package com.exam.exam.Model;

import java.util.HashSet;
//import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionid;
	
	@Column(length = 50000)
	private String content;
	
	private String answer;
	
	private String image;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	private Quizz quiz;

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public Quizz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quizz quiz) {
		this.quiz = quiz;
	}

	public Question(int questionid, String content, String answer, String image, String option1, String option2,
			String option3, String option4, Quizz quiz) {
		super();
		this.questionid = questionid;
		this.content = content;
		this.answer = answer;
		this.image = image;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.quiz = quiz;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", content=" + content + ", answer=" + answer + ", image=" + image
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", quiz=" + quiz + "]";
	}
	
	
}
