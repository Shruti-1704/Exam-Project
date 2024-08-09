package com.app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Questions;
import com.app.model.Quiz;
import com.app.repository.QuestionRepo;
import com.app.repository.QuizRepo;

@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	private QuestionRepo quesRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	
//======= create Question ==========================================================	
	public Questions addQuestion(Questions question)
	{
		return this.quesRepo.save(question);
	}
	
//======== update Question ===============================================================	
	public Questions updateQuestion(Questions question)
	{
		return this.quesRepo.save(question);
	}

//========= get all Questions ===========================================================	
	public Set<Questions> getQuestions()
	{
		return new HashSet<>(this.quesRepo.findAll());
	}
	
//========== get single Question by quesid =================================================	
	public Questions getQuestion(int quesId) {
		
		return this.quesRepo.findById(quesId).get();
	}

//========== get Questions by Quiz ===================================================	
	
	public Set<Questions> getQuestionsofQuiz(int quizId)
	{
		Quiz quiz = new Quiz();
		quiz = this.quizRepo.getById(quizId);
		Set<Questions> questions = this.quesRepo.findByQuiz(quiz);
		
		return questions;
	}
//========= delete Question ===============================================================
	@Override
	public void deleteQuestion(int quesId) {
		
		this.quesRepo.deleteById(quesId);
		
	}
//============================================================================================
}
