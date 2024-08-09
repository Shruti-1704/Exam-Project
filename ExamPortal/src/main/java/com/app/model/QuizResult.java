package com.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class QuizResult 
{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int resultid;
	
	@Column
	private int uid;
	@Column
	private int quizid;
	@Column
	private int numofquestions;
	@Column
	private int correctanswers;
	@Column
	private int marksgot;
	@Column
	private int attempted;
	@Column
	private String date;
	
	@Transient
	private String title;
	@Transient
	private String imagefile;
	
	@OneToMany(mappedBy ="quizresult",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Userqna> userqnas;

	public QuizResult() {
		super();
	}

	public QuizResult(int resultid, int uid, int quizid, int numofquestions, int correctanswers, int marksgot,
			int attempted, String date, String title, String imagefile) {
		super();
		this.resultid = resultid;
		this.uid = uid;
		this.quizid = quizid;
		this.numofquestions = numofquestions;
		this.correctanswers = correctanswers;
		this.marksgot = marksgot;
		this.attempted = attempted;
		this.date = date;
		this.title = title;
		this.imagefile = imagefile;
	}

	public int getResultid() {
		return resultid;
	}

	public void setResultid(int resultid) {
		this.resultid = resultid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public int getNumofquestions() {
		return numofquestions;
	}

	public void setNumofquestions(int numofquestions) {
		this.numofquestions = numofquestions;
	}

	public int getCorrectanswers() {
		return correctanswers;
	}

	public void setCorrectanswers(int correctanswers) {
		this.correctanswers = correctanswers;
	}

	public int getMarksgot() {
		return marksgot;
	}

	public void setMarksgot(int marksgot) {
		this.marksgot = marksgot;
	}

	public int getAttempted() {
		return attempted;
	}

	public void setAttempted(int attempted) {
		this.attempted = attempted;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

	public List<Userqna> getUserqnas() {
		return userqnas;
	}

	public void setUserqnas(List<Userqna> userqnas) {
		this.userqnas = userqnas;
	}
	
	
}
