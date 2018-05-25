package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveUser")
public class AdaptiveUser {
    @Id
	private Long id;
	private int user_id;
	private String timeStamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "AdaptiveUser [id=" + id + ", user_id=" + user_id + ", timeStamp=" + timeStamp + "]";
	}
	
}
