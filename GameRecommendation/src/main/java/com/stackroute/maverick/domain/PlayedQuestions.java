package com.stackroute.maverick.domain;

import java.util.Arrays;

public class PlayedQuestions {
	 private int gameId;
	    private int qId;
	    private int questionLevel;
	    private String question;
	    private String options[];
	    private String cAns;
	    private GameQuestionLevel qLevels;
	    private GameQuestionTime questionTime;
	    private GameQuestionScore questionScore;
	    private String clickedAnswer;
		public int getGameId() {
			return gameId;
		}
		public void setGameId(int gameId) {
			this.gameId = gameId;
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
		public String getClickedAnswer() {
			return clickedAnswer;
		}
		public void setClickedAnswer(String clickedAnswer) {
			this.clickedAnswer = clickedAnswer;
		}
		@Override
		public String toString() {
			return "PlayedQuestions [gameId=" + gameId + ", qId=" + qId + ", questionLevel=" + questionLevel
					+ ", question=" + question + ", options=" + Arrays.toString(options) + ", cAns=" + cAns
					+ ", qLevels=" + qLevels + ", questionTime=" + questionTime + ", questionScore=" + questionScore
					+ ", clickedAnswer=" + clickedAnswer + "]";
		}
	    
}
