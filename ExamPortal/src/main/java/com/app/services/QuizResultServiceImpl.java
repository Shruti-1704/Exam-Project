package com.app.services;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomException;
import com.app.model.Questions;
import com.app.model.Quiz;
import com.app.model.QuizResult;
import com.app.repository.QuizResultRepo;

@Service
public class QuizResultServiceImpl implements QuizResultService
{
	@Autowired
	private QuizResultRepo quizResultRepo;
	
	@Autowired
	private QuestionService quesServ;
	
	@Autowired
	private QuizService quizServ;

	@Override
	public QuizResult addResult(QuizResult quizresult) throws CustomException {
		
	try{
		
		Quiz quiz = this.quizServ.getQuiz(quizresult.getQuizid());
		
		Questions question;
		int correctanswers = 0;
		int length = quizresult.getUserqnas().toArray().length;
		int attempted = 0;
		for(int i = 0; i < length; i++)
		{
			question = this.quesServ.getQuestion(quizresult.getUserqnas().get(i).getQuesid());
			if(question.getAnswer().equals(quizresult.getUserqnas().get(i).getAnswer()))
			{
				correctanswers ++;
			}
			
			if(!quizresult.getUserqnas().get(i).getAnswer().equals(""))
			{
				attempted ++;
			}
		}
		
		
		quizresult.setCorrectanswers(correctanswers);
		
		int marksgot = (int)(correctanswers * quiz.getMaxmarks()/ length);
		quizresult.setMarksgot(marksgot);
		quizresult.setAttempted(attempted);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		quizresult.setDate(formatter.format(new Date()));
		
	}catch(Exception e){
		
		 System.out.println("\n=======================================================================================================================\n"
		           + "         Message: "+e+"\n"
		           + "=================================================================================================================================");
		
		 throw new CustomException("Exception: "+e);
		 
	}
		
		System.out.println("============================================================================================================================================");
		
		System.out.println("uid: " + quizresult.getUid());
		System.out.println("quizid: " + quizresult.getQuizid());
		System.out.println("numofquestions: " + quizresult.getNumofquestions());
		System.out.println("correctanswers: " + quizresult.getCorrectanswers());
		System.out.println("marksgot: " + quizresult.getMarksgot());
		System.out.println("date: " + quizresult.getDate());
		System.out.println("quesid: " + quizresult.getUserqnas().get(0).getQuesid());
		System.out.println("answer: " + quizresult.getUserqnas().get(0).getAnswer());
		System.out.println("============================================================================================================================================");

		
		return this.quizResultRepo.save(quizresult);
	}

	@Override
	public List<QuizResult> getResults() {
		return new ArrayList<>(this.quizResultRepo.findAll());
	}

	@Override
	public QuizResult getResult(int resultid) {
		
		return this.quizResultRepo.findById(resultid).get();
	}

	@Override
	public QuizResult getCurrentResult() throws CustomException {
		
//=====================================================================================================================================
		
		String filePath = "src/main/resources/static/image/";
		//	String filePath = context.getRealPath("/static/image");
			File fileFolder = new File(filePath);
		
		Quiz quiz;
		QuizResult result = this.quizResultRepo.findCurrentResult();
		
			quiz = this.quizServ.getQuiz(result.getQuizid());
			result.setTitle(quiz.getTitle());
			
			
			File file = new File(filePath+quiz.getImage());
			
			if(file.exists())
			{
		
				String encodeBase64 = null;
				 try {
					 
					 String extension =FilenameUtils.getExtension(quiz.getImage());
					 FileInputStream fileInputStream = new FileInputStream(file);
					 byte[] bytes = new byte[(int)file.length()];
					 fileInputStream.read(bytes);
					 encodeBase64 = Base64.getEncoder().encodeToString(bytes);
					 quiz.setImagefile("data:image/"+extension+";base64,"+encodeBase64);
					 fileInputStream.close();
					 
					 
				 }catch (Exception e) {
					 
					 System.out.println("\n=================================================================================================================\n"
					           + "         Message: "+ e +"   \n"
					           + "==========================================================================================================================");
					
					 throw new CustomException("Exception: "+ e +"");
				 }
			
		
			result.setImagefile(quiz.getImagefile());
		};
		

		
		
//======================================================================================================================================		
		return this.quizResultRepo.findCurrentResult();
	}

	@Override
	public void deleteResult(int resultid) {
		
		 this.quizResultRepo.deleteById(resultid);
	}

	@Override
	public void deleteAllResult() {
			
		this.quizResultRepo.deleteAll();
	}

	@Override
	public List<QuizResult> getResultsofUser(int uid) throws CustomException {
		
		String filePath = "src/main/resources/static/image/";
		//	String filePath = context.getRealPath("/static/image");
			File fileFolder = new File(filePath);
		
		Quiz quiz;
		List<QuizResult> results = this.quizResultRepo.findByUid(uid);
		int length = results.toArray().length;
		
		for(int i = 0 ; i< length;i++)
		{
			quiz = this.quizServ.getQuiz(results.get(i).getQuizid());
			results.get(i).setTitle(quiz.getTitle());
			
			
			
			
			File file = new File(filePath+quiz.getImage());
			
			if(file.exists())
			{
		
				String encodeBase64 = null;
				 try {
					 
					 String extension =FilenameUtils.getExtension(quiz.getImage());
					 FileInputStream fileInputStream = new FileInputStream(file);
					 byte[] bytes = new byte[(int)file.length()];
					 fileInputStream.read(bytes);
					 encodeBase64 = Base64.getEncoder().encodeToString(bytes);
					 quiz.setImagefile("data:image/"+extension+";base64,"+encodeBase64);
					 fileInputStream.close();
					 
					 
				 }catch (Exception e) {
					 
					 System.out.println("\n=================================================================================================================\n"
					           + "         Message: "+ e +"   \n"
					           + "==========================================================================================================================");
					
					 throw new CustomException("Exception: "+ e +"");
				
				}
			}
			results.get(i).setImagefile(quiz.getImagefile());
		};
		

		
		return results;
	}

	@Override
	public void deleteAllResultOfUser(int uid) {
		
	 this.quizResultRepo.deleteByUid(uid);
		
	}
}
