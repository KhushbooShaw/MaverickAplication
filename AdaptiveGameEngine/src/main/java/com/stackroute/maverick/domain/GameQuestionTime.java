package com.stackroute.maverick.domain;

public class GameQuestionTime {
	    private int gqTimeId;
	    private int easyQuestionsTime;
	    private int mediumQuestionsTime;
	    private int advanceQuestionsTime;
		public int getGqTimeId() {
			return gqTimeId;
		}
		public void setGqTimeId(int gqTimeId) {
			this.gqTimeId = gqTimeId;
		}
		public int getEasyQuestionsTime() {
			return easyQuestionsTime;
		}
		public void setEasyQuestionsTime(int easyQuestionsTime) {
			this.easyQuestionsTime = easyQuestionsTime;
		}
		public int getMediumQuestionsTime() {
			return mediumQuestionsTime;
		}
		public void setMediumQuestionsTime(int mediumQuestionsTime) {
			this.mediumQuestionsTime = mediumQuestionsTime;
		}
		public int getAdvanceQuestionsTime() {
			return advanceQuestionsTime;
		}
		public void setAdvanceQuestionsTime(int advanceQuestionsTime) {
			this.advanceQuestionsTime = advanceQuestionsTime;
		}
		@Override
		public String toString() {
			return "GameQuestionTime [gqTimeId=" + gqTimeId + ", easyQuestionsTime=" + easyQuestionsTime
					+ ", mediumQuestionsTime=" + mediumQuestionsTime + ", advanceQuestionsTime=" + advanceQuestionsTime
					+ "]";
		}
	    
}
