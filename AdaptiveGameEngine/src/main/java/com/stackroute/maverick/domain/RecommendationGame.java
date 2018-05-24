package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label= "Games")
public class RecommendationGame {

	    @Id
	    @GeneratedValue
	    private Long id;
		private String name;
		private int category_id;
		private String game_type;
		private int no_of_player;
		private int no_of_question;
	    private int game_id;
	    private int game_type_id;
	    private int topic_id;
	    private Date timestamp;
		

		public int getTopic_id() {
			return topic_id;
		}

		public void setTopic_id(int topic_id) {
			this.topic_id = topic_id;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
	    
	    
	    public int getGame_type_id() {
			return game_type_id;
		}

		public void setGame_type_id(int game_type_id) {
			this.game_type_id = game_type_id;
		}

		public int getGame_id() {
			return game_id;
		}

		public void setGame_id(int game_id) {
			this.game_id = game_id;
		}

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
        public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		public int getCategory_id() {
	        return category_id;
	    }
        public String getGame_type() {
	        return game_type;
	    }

	    public void setGame_type(String game_type) {
	        this.game_type = game_type;
	    }
        public int getNo_of_question() {
	        return no_of_question;
	    }

	    public void setNo_of_question(int no_of_question) {
	        this.no_of_question = no_of_question;
	    }
		public int getNo_of_player() {
	        return no_of_player;
	    }

	    public void setNo_of_player(int no_of_player) {
	        this.no_of_player = no_of_player;
	    }

		@Override
		public String toString() {
			return "RecommendationGame [id=" + id + ", name=" + name + ", category_id=" + category_id + ", game_type="
					+ game_type + ", no_of_player=" + no_of_player + ", no_of_question=" + no_of_question + ", game_id="
					+ game_id + ", game_type_id=" + game_type_id + ", topic_id=" + topic_id + ", timestamp=" + timestamp
					+ "]";
		}

		

	
}
