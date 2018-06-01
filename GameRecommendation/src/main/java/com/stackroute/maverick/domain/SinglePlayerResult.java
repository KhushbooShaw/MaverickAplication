package com.stackroute.maverick.domain;

import java.util.List;

public class SinglePlayerResult {
	private List<PlayedQuestions> playedData;
	    private int Score;
	    private int gameSessionId;
		public List<PlayedQuestions> getPlayedData() {
			return playedData;
		}
		public void setPlayedData(List<PlayedQuestions> playedData) {
			this.playedData = playedData;
		}
		public int getScore() {
			return Score;
		}
		public void setScore(int score) {
			Score = score;
		}
		public int getGameSessionId() {
			return gameSessionId;
		}
		public void setGameSessionId(int gameSessionId) {
			this.gameSessionId = gameSessionId;
		}
		@Override
		public String toString() {
			return "SinglePlayerResult [playedData=" + playedData + ", Score=" + Score + ", gameSessionId="
					+ gameSessionId + "]";
		}
		
	    
}
