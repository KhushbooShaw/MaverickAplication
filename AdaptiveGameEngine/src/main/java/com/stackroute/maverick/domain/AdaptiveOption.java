package com.stackroute.maverick.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "AdaptiveOption")
public class AdaptiveOption {
  @Id
  private Long id;
  private int option_id;
  private String option_value;
  private String timeStamp;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getOption_id() {
	return option_id;
}
public void setOption_id(int option_id) {
	this.option_id = option_id;
}
public String getOption_value() {
	return option_value;
}
public void setOption_value(String option_value) {
	this.option_value = option_value;
}
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}
@Override
public String toString() {
	return "AdaptiveOption [id=" + id + ", option_id=" + option_id + ", option_value=" + option_value + ", timeStamp="
			+ timeStamp + "]";
}
  
}
