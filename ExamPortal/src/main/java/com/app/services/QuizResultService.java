package com.app.services;

import java.util.List;

import com.app.exception.CustomException;
import com.app.model.QuizResult;

public interface QuizResultService
{
public QuizResult addResult(QuizResult result) throws CustomException;
	
	public List<QuizResult> getResults();
	
	public QuizResult getResult(int resultid);
	
	public QuizResult getCurrentResult() throws CustomException;
	
	public void deleteResult(int resultid);
	
	public void deleteAllResult();
	
	public List<QuizResult> getResultsofUser(int uid) throws CustomException;
	
	public void deleteAllResultOfUser(int uid);
}
