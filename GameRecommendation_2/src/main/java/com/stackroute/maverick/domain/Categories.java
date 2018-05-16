package com.stackroute.maverick.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


public class Categories {
	@Id
    @GeneratedValue
    private Long id;
    private String name;
    private int no_of_topics;
    private String img;
           

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
	
	public String toString(){
		String info = String.format("{ 'name': %s, 'id': %d}", name, id);
		return info;
	}
   

}
