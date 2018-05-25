package com.stackroute.maverick.domain;

import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "RecommendationCategory")
public class RecommendationCategory {
	    @Id
	    private Long id;
	    private int category_id;
	    private String name;
	    private String img;
	    private String timeStamp;
		
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getCategory_id() {
			return category_id;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
	    }

	    public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
	    }

		public String getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(String timestamp) {
			this.timeStamp = timestamp;
		}

		@Override
		public String toString() {
			return "RecommendationCategory [id=" + id + ", category_id=" + category_id + ", name=" + name + ", img="
					+ img + ", timeStamp=" + timeStamp + "]";
		}

		
        
		
}
