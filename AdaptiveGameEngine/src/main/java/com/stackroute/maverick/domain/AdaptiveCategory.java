package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveCategory")
public class AdaptiveCategory {
    @Id
    @GeneratedValue
    private Long id;
    private int category_id;
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
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "AdaptiveCategory [id=" + id + ", category_id=" + category_id + ", timeStamp=" + timeStamp + "]";
	}
    
}
