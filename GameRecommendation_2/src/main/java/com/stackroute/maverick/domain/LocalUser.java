package com.stackroute.maverick.domain;

import java.util.Arrays;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "User")
public class LocalUser {
	// @Id
		// @GeneratedValue
	    @GraphId
		private Long id;
		private String name;
		private String gender;
		private String location;
		private String[] fav_category;
		

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

		public String getGender() {
			return gender;
		}

//		public int getId() {
//			return id;
//		}
	//
//		public void setId(int id) {
//			this.id = id;
//		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String[] getFav_category() {
			return fav_category;
		}

		public void setFav_category(String[] fav_category) {
			this.fav_category = fav_category;
		}

		public String getLocation() {
			return location;
		}

//		public String getUserName() {
//			return userName;
//		}
	//
//		public void setUserName(String userName) {
//			this.userName = userName;
//		}

		public void setLocation(String location) {
			this.location = location;
		}

//		@Override
//		public String toString() {
//			return "User [id=" + id + ", userName=" + userName + ", gender=" + gender + ", location=" + location + "]";
//		}
	//	

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", location=" + location + ", fav_category="
					+ Arrays.toString(fav_category) + "]";
		}

}
