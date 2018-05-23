package com.stackroute.maverick.domain;


public class User  {

	 
	    private int id;
	    
	    private String userName;
	    
	    private String password;
	   
	    private String email;
	    
	    private String location;
	    
	    private String mobile;
	  
	    private String gender;
	   
	    private int age;
	    
	    private String role;
	    
	    
	    public String getRole() {
	        return role;
	    }
	    public void setRole(String role) {
	        this.role = role;
	    }
	    public User() {
	    
	    }
	    public User(int id, String userName, String password, String email, String location, String mobile, String gender,
	            int age) {
	        super();
	        this.id = id;
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	        this.location = location;
	        this.mobile = mobile;
	        this.gender = gender;
	        this.age = age;
	    }    public int getId() {
	        return id;
	    }    public void setId(int id) {
	        this.id = id;
	    }    public String getUserName() {
	        return userName;
	    }    public void setUserName(String userName) {
	        this.userName = userName;
	    }    public String getPassword() {
	        return password;
	    }    public void setPassword(String password) {
	        this.password = password;
	    }    public String getEmail() {
	        return email;
	    }    public void setEmail(String email) {
	        this.email = email;
	    }    public String getLocation() {
	        return location;
	    }    public void setLocation(String location) {
	        this.location = location;
	    }    public String getMobile() {
	        return mobile;
	    }    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }    public String getGender() {
	        return gender;
	    }    public void setGender(String gender) {
	        this.gender = gender;
	    }    public int getAge() {
	        return age;
	    }    public void setAge(int age) {
	        this.age = age;
	    }    @Override
	    public String toString() {
	        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
	                + ", location=" + location + ", mobile=" + mobile + ", gender=" + gender + ", age=" + age + ", role="
	                + role + "]";
	    }
	    
	    
}
