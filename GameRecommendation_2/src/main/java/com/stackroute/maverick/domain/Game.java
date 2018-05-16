package com.stackroute.maverick.domain;

import java.util.Date;
import java.util.List;

public class Game {
	
    private int gameId;
    private String createdBy;
    private Date createdOn;
    private String gameType;
    private String gameDescription;
    private String gameRules;
    private int gamePopularity; 
    private GameQuestionLevel questionLevels; 
    private GameQuestionTime questionTime;  
    private GameQuestionScore questionScore;
    private Category category;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getGameDescription() {
		return gameDescription;
	}
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	public String getGameRules() {
		return gameRules;
	}
	public void setGameRules(String gameRules) {
		this.gameRules = gameRules;
	}
	public int getGamePopularity() {
		return gamePopularity;
	}
	public void setGamePopularity(int gamePopularity) {
		this.gamePopularity = gamePopularity;
	}
	public GameQuestionLevel getQuestionLevels() {
		return questionLevels;
	}
	public void setQuestionLevels(GameQuestionLevel questionLevels) {
		this.questionLevels = questionLevels;
	}
	public GameQuestionTime getQuestionTime() {
		return questionTime;
	}
	public void setQuestionTime(GameQuestionTime questionTime) {
		this.questionTime = questionTime;
	}
	public GameQuestionScore getQuestionScore() {
		return questionScore;
	}
	public void setQuestionScore(GameQuestionScore questionScore) {
		this.questionScore = questionScore;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
}
