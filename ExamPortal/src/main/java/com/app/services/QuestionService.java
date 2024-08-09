package com.app.services;

import java.util.Set;

import com.app.model.Questions;

public interface QuestionService 
{
	public Questions addQuestion(Questions question);
	
	public Questions updateQuestion(Questions question);
	
	public Set<Questions> getQuestions();
	
	public Questions getQuestion(int quesId);
	
	public void deleteQuestion(int quesId);
	
	public Set<Questions> getQuestionsofQuiz(int quizId);

}
