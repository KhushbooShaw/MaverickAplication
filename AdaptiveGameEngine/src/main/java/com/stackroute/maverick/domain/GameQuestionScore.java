package com.stackroute.maverick.domain;

public class GameQuestionScore {
	private int gqScoreId;
    private int easyQuestionsScore;
    private int mediumQuestionsScore;
    private int advanceQuestionsScore;
	public int getGqScoreId() {
		return gqScoreId;
	}
	public void setGqScoreId(int gqScoreId) {
		this.gqScoreId = gqScoreId;
	}
	public int getEasyQuestionsScore() {
		return easyQuestionsScore;
	}
	public void setEasyQuestionsScore(int easyQuestionsScore) {
		this.easyQuestionsScore = easyQuestionsScore;
	}
	public int getMediumQuestionsScore() {
		return mediumQuestionsScore;
	}
	public void setMediumQuestionsScore(int mediumQuestionsScore) {
		this.mediumQuestionsScore = mediumQuestionsScore;
	}
	public int getAdvanceQuestionsScore() {
		return advanceQuestionsScore;
	}
	public void setAdvanceQuestionsScore(int advanceQuestionsScore) {
		this.advanceQuestionsScore = advanceQuestionsScore;
	}
	@Override
	public String toString() {
		return "GameQuestionScore [gqScoreId=" + gqScoreId + ", easyQuestionsScore=" + easyQuestionsScore
				+ ", mediumQuestionsScore=" + mediumQuestionsScore + ", advanceQuestionsScore=" + advanceQuestionsScore
				+ "]";
	}
    

}
