package com.stackroute.maverick.domain;

import java.util.List;

public class AdaptiveResult {
	
	private int user_id;
	
	private int category_id;
	
	private int topic_id;
	
	private int game_id;
	
	private List<AdaptiveResponseQuestion> response;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public List<AdaptiveResponseQuestion> getResponse() {
		return response;
	}

	public void setResponse(List<AdaptiveResponseQuestion> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "AdaptiveResult [user_id=" + user_id + ", category_id=" + category_id + ", topic_id=" + topic_id
				+ ", game_id=" + game_id + ", response=" + response + "]";
	}
	
	

}
