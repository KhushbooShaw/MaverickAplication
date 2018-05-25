package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label= "RecommendationGame")
public class RecommendationGame {

	    @Id
	    private Long id;
		private String name;
		private String gameImage;
		private int category_id;
		private String game_type;
	    private int game_id;
	    private int game_type_id;
	    private int topic_id;
	    private String game_rules;
	    private String timeStamp;
		private String game_description;
		private String recommendation;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGameImage() {
			return gameImage;
		}
		public void setGameImage(String gameImage) {
			this.gameImage = gameImage;
		}
		public int getCategory_id() {
			return category_id;
		}
		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		public String getGame_type() {
			return game_type;
		}
		public void setGame_type(String game_type) {
			this.game_type = game_type;
		}
		public int getGame_id() {
			return game_id;
		}
		public void setGame_id(int game_id) {
			this.game_id = game_id;
		}
		public int getGame_type_id() {
			return game_type_id;
		}
		public void setGame_type_id(int game_type_id) {
			this.game_type_id = game_type_id;
		}
		public int getTopic_id() {
			return topic_id;
		}
		public void setTopic_id(int topic_id) {
			this.topic_id = topic_id;
		}
		public String getGame_rules() {
			return game_rules;
		}
		public void setGame_rules(String game_rules) {
			this.game_rules = game_rules;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		
		
		public String getGame_description() {
			return game_description;
		}
		public void setGame_description(String game_description) {
			this.game_description = game_description;
		}
		public String getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(String recommendation) {
			this.recommendation = recommendation;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		@Override
		public String toString() {
			return "RecommendationGame [id=" + id + ", name=" + name + ", gameImage=" + gameImage + ", category_id="
					+ category_id + ", game_type=" + game_type + ", game_id=" + game_id + ", game_type_id="
					+ game_type_id + ", topic_id=" + topic_id + ", game_rules=" + game_rules + ", timeStamp="
					+ timeStamp + ", game_description=" + game_description + ", recommendation=" + recommendation + "]";
		}
		
		
		
}
