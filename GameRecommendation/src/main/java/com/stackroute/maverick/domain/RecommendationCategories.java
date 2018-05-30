package com.stackroute.maverick.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "RecommendationCategories")
public class RecommendationCategories {
	@Id
	Long id;
	int categories_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	@Override
	public String toString() {
		return "RecommendationCategories [id=" + id + ", categories_id=" + categories_id + "]";
	}
	

}
