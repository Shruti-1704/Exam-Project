package com.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.Questions;
import com.app.model.Quiz;

public interface QuestionRepo extends JpaRepository<Questions, Integer> 
{

	Set<Questions> findByQuiz(Quiz quiz);
}
