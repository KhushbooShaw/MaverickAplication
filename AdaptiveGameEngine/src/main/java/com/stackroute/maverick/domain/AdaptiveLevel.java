package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveLevel")
public class AdaptiveLevel {
	
	@Id
	private Long id;
    private String timeStamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "AdaptiveLevel [id=" + id + ", timeStamp=" + timeStamp + "]";
	}
    
}
