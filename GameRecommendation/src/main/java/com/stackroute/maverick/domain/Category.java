package com.stackroute.maverick.domain;

import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "Category")
public class Category {
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

		

	
		
//	 @Id
//	    @GeneratedValue
//	    private Long id;
//	    private String name;
//	   // private String img;
//	   // private Date timestamp;
//		
//
//		
//		public Date getTimestamp() {
//			return timestamp;
//		}
//
//		public void setTimestamp(Date timestamp) {
//			this.timestamp = timestamp;
//		}
//	           
//
//	    public Long getId() {
//	        return id;
//	    }
//
//	    public void setId(Long id) {
//	        this.id = id;
//	    }
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//	    }
//	
//	    public String getImg() {
//			return img;
//		}
//
//		public void setImg(String img) {
//			this.img = img;
//	    }
//
//		@Override
//		public String toString() {
//			return "Category [id=" + id + ", name=" + name + ", img=" + img + ", timestamp=" + timestamp + "]";
//		}
//
//		
//
//		
//
//	
////	private int categoryId;
////
////	private String categoryName;
////
////	private String categoryImage;
////
////	private List<Topic> topic;
////
////	public int getCategoryId() {
////		return categoryId;
////	}
////
////	public void setCategoryId(int categoryId) {
////		this.categoryId = categoryId;
////	}
////
////	public String getCategoryName() {
////		return categoryName;
////	}
////
////	public void setCategoryName(String categoryName) {
////		this.categoryName = categoryName;
////	}
////
////	public String getCategoryImage() {
////		return categoryImage;
////	}
////
////	public void setCategoryImage(String categoryImage) {
////		this.categoryImage = categoryImage;
////	}
////
////	public List<Topic> getTopic() {
////		return topic;
////	}
////
////	public void setTopic(List<Topic> topic) {
////		this.topic = topic;
////	}
////
////	@Override
////	public String toString() {
////		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryImage="
////				+ categoryImage + ", topic=" + topic + "]";
////	}
////	
////   
}