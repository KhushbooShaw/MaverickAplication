package com.stackroute.maverick.domain;

public class GameQuestionLevel {
	 private int gqLevelId;
	    private int easyLevel;
	    private int mediumLevel;
	    private int advancedLevel;
		public int getGqLevelId() {
			return gqLevelId;
		}
		public void setGqLevelId(int gqLevelId) {
			this.gqLevelId = gqLevelId;
		}
		public int getEasyLevel() {
			return easyLevel;
		}
		public void setEasyLevel(int easyLevel) {
			this.easyLevel = easyLevel;
		}
		public int getMediumLevel() {
			return mediumLevel;
		}
		public void setMediumLevel(int mediumLevel) {
			this.mediumLevel = mediumLevel;
		}
		public int getAdvancedLevel() {
			return advancedLevel;
		}
		public void setAdvancedLevel(int advancedLevel) {
			this.advancedLevel = advancedLevel;
		}
		@Override
		public String toString() {
			return "GameQuestionLevel [gqLevelId=" + gqLevelId + ", easyLevel=" + easyLevel + ", mediumLevel="
					+ mediumLevel + ", advancedLevel=" + advancedLevel + "]";
		}
	    
}
