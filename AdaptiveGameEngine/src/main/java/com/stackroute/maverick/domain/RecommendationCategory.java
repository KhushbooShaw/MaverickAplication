package com.stackroute.maverick.domain;

import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

//@NodeEntity(label = "Category")
public class RecommendationCategory {
	    @Id
	    @GeneratedValue
	    private Long id;
	    private String name;
	    private int no_of_topics;
	    private String img;
	    //private Date timestamp;
		

		
//		public Date getTimestamp() {
//			return timestamp;
//		}
//
//		public void setTimestamp(Date timestamp) {
//			this.timestamp = timestamp;
//		}
	           

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
	    public int getNo_of_topics() {
	        return no_of_topics;
	    }

	    public void setNo_of_topics(int no_of_topics) {
	        this.no_of_topics = no_of_topics;
	    }
	    public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
	    }

//		@Override
//		public String toString() {
//			return "RecommendationCategory [id=" + id + ", name=" + name + ", no_of_topics=" + no_of_topics + ", img="
//					+ img + ", timestamp=" + timestamp + "]";
//		}

		

	
		
}
