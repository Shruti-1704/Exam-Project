package com.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Userqna 
{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int uqna;
	private int quesid;
	private String answer;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "quizresult_resultid", nullable = false)
	private QuizResult quizresult;


	public Userqna() {
		super();
	}


	public Userqna(int uqna, int quesid, String answer) {
		super();
		this.uqna = uqna;
		this.quesid = quesid;
		this.answer = answer;
	}


	public int getUqna() {
		return uqna;
	}


	public void setUqna(int uqna) {
		this.uqna = uqna;
	}


	public int getQuesid() {
		return quesid;
	}


	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public QuizResult getQuizresult() {
		return quizresult;
	}


	public void setQuizresult(QuizResult quizresult) {
		this.quizresult = quizresult;
	}

	
}
