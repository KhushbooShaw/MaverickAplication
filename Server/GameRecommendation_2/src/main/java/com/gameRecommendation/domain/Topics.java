package com.gameRecommendation.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label= "Games")
public class Topics {

	    @Id
	    @GeneratedValue
	    private Long id;
		private String name;
		private Long category_id;
		private String game_type;
		private int no_of_player;
		private int no_of_question;
	  
	    
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
        public void setCategory_id(Long category_id) {
			this.category_id = category_id;
		}
		public Long getCategory_id() {
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

		
		public String toString(){
			String info = String.format("{ 'name': %s, 'id': %d}", name, id);
			return info;
		}
}
