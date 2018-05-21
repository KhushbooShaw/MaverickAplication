package com.stackroute.maverick.domain;

public class GameType {
	private int gameTypeId;
    private String singlePlayerTimeBasedGame;
    private String multiPlayerFastestFingerFirst;
    private String singlePlayerAdaptiveGame;
	public int getGameTypeId() {
		return gameTypeId;
	}
	public void setGameTypeId(int gameTypeId) {
		this.gameTypeId = gameTypeId;
	}
	public String getSinglePlayerTimeBasedGame() {
		return singlePlayerTimeBasedGame;
	}
	public void setSinglePlayerTimeBasedGame(String singlePlayerTimeBasedGame) {
		this.singlePlayerTimeBasedGame = singlePlayerTimeBasedGame;
	}
	public String getMultiPlayerFastestFingerFirst() {
		return multiPlayerFastestFingerFirst;
	}
	public void setMultiPlayerFastestFingerFirst(String multiPlayerFastestFingerFirst) {
		this.multiPlayerFastestFingerFirst = multiPlayerFastestFingerFirst;
	}
	public String getSinglePlayerAdaptiveGame() {
		return singlePlayerAdaptiveGame;
	}
	public void setSinglePlayerAdaptiveGame(String singlePlayerAdaptiveGame) {
		this.singlePlayerAdaptiveGame = singlePlayerAdaptiveGame;
	}
	@Override
	public String toString() {
		return "GameType [gameTypeId=" + gameTypeId + ", singlePlayerTimeBasedGame=" + singlePlayerTimeBasedGame
				+ ", multiPlayerFastestFingerFirst=" + multiPlayerFastestFingerFirst + ", singlePlayerAdaptiveGame="
				+ singlePlayerAdaptiveGame + "]";
	}
    
}
