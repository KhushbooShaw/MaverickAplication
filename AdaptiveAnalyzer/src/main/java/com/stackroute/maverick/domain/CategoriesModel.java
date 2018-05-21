package com.stackroute.maverick.domain;

public class CategoriesModel {
	private int categoryId;
    private String categoryName;
    private String categoryImage;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	@Override
	public String toString() {
		return "CategoriesModel [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryImage="
				+ categoryImage + "]";
	}
    

}
