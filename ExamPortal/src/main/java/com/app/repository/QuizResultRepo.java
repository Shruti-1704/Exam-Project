package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.QuizResult;

public interface QuizResultRepo extends JpaRepository<QuizResult, Integer>
{
	@Query(value ="Select * from Result where resultid=( select max(resultid) from Result)",nativeQuery  = true)
	QuizResult findCurrentResult();
	
//	@Query("select q from Quiz q where q.category = :category")
//	Set<Quiz> findByCategory(@Param("category")Category category);

	
	public List<QuizResult> findByUid(int uid);
	
	public void deleteByUid(int uid);
}
