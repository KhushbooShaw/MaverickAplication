package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveTopic")
public class AdaptiveTopic {
	@Id
	private Long id;
    private int topic_id;
    private String timeStamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "AdaptiveTopic [id=" + id + ", topic_id=" + topic_id + ", timeStamp=" + timeStamp + "]";
	}
    
}
