package com.stackroute.maverick.domain;

public class SelectedCategoriesModel {
	 private int tid;
     private int SelectedCategoryId;
    private int userId;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSelectedCategoryId() {
		return SelectedCategoryId;
	}
	public void setSelectedCategoryId(int selectedCategoryId) {
		SelectedCategoryId = selectedCategoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SelectedCategoriesModel [tid=" + tid + ", SelectedCategoryId=" + SelectedCategoryId + ", userId="
				+ userId + "]";
	}
    
}
