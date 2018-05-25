package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveQuestion")
public class AdaptiveQuestion {
	@Id
	private Long id;
	private int questionId;
	private String questionStem;

	private int questionLevel;

	private String correctAnswer;
	
	private String timeStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionStem() {
		return questionStem;
	}

	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
	}

	public int getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "AdaptiveQuestion [id=" + id + ", questionId=" + questionId + ", questionStem=" + questionStem
				+ ", questionLevel=" + questionLevel + ", correctAnswer=" + correctAnswer + ", timeStamp=" + timeStamp
				+ "]";
	}
    
}
