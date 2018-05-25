package com.stackroute.maverick.domain;

import java.util.Arrays;

public class PlayedQuestions {
	private int gameId;
    private int categoryId;
    private String gameName;
    private String gameImage;
    private int userId;
    private int qId;
    private int questionLevel;
    private String question;
    private String options[];
    private String cAns;
    private GameType gameType;
    private GameQuestionLevel qLevels;
    private GameQuestionTime questionTime;
    private GameQuestionScore questionScore;
    private String answer;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getcAns() {
		return cAns;
	}
	public void setcAns(String cAns) {
		this.cAns = cAns;
	}
	public GameType getGameType() {
		return gameType;
	}
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}
	public GameQuestionLevel getqLevels() {
		return qLevels;
	}
	public void setqLevels(GameQuestionLevel qLevels) {
		this.qLevels = qLevels;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "PlayedQuestions [gameId=" + gameId + ", categoryId=" + categoryId + ", gameName=" + gameName
				+ ", gameImage=" + gameImage + ", userId=" + userId + ", qId=" + qId + ", questionLevel="
				+ questionLevel + ", question=" + question + ", options=" + Arrays.toString(options) + ", cAns=" + cAns
				+ ", gameType=" + gameType + ", qLevels=" + qLevels + ", questionTime=" + questionTime
				+ ", questionScore=" + questionScore + ", answer=" + answer + "]";
	}
    
}
