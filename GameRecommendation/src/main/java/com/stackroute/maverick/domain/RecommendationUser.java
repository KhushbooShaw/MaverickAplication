package com.stackroute.maverick.domain;

import java.util.Arrays;
import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "RecommendationUser")
public class RecommendationUser {
	@Id
	private Long id;
	
	private int userId;
    
    private String userName;
    
   
    private String location;
    
   
    private String gender;
   
    private String age;
    
    
    
    private String timestamp;
    
    
    public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
   public int getUserId() {
        return userId;
    }    public void setUserId(int id) {
        this.userId = id;
    }    public String getUserName() {
        return userName;
    }    public void setUserName(String userName) {
        this.userName = userName;
    }    public String getLocation() {
        return location;
    }    public void setLocation(String location) {
        this.location = location;
    }     public String getGender() {
        return gender;
    }    public void setGender(String gender) {
        this.gender = gender;
    }    public String getAge() {
        return age;
    }    public void setAge(String age) {
        this.age = age;
    }
	@Override
	public String toString() {
		return "RecommendationUser [id=" + id + ", userId=" + userId + ", userName=" + userName + ", location="
				+ location + ", gender=" + gender + ", age=" + age + ", timestamp=" + timestamp + "]";
	}
	
    
}
