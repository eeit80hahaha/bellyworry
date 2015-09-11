package food.recipes.model;

import java.io.Serializable;

public class CookVO implements Serializable{
	private int cookNo;
	private String wayNo;
	private java.sql.Blob picture;
	public CookVO(){
		
	}	

	public boolean equals(Object obj){
		if(obj!=null && (obj instanceof CookVO)){
			CookVO temp = (CookVO) obj;
			if(this.cookNo == temp.cookNo){
				return true;
			}
		}
		return false;
	}

	public String toString(){
		return "("+cookNo+":"+ wayNo+")";
	}
	
	public int getCookNo() {
		return cookNo;
	}
	public void setCookNo(int cookNo) {
		this.cookNo = cookNo;
	}
	public String getWayNo() {
		return wayNo;
	}
	public void setWayNo(String wayNo) {
		this.wayNo = wayNo;
	}

	public java.sql.Blob getPicture() {
		return picture;
	}

	public void setPicture(java.sql.Blob picture) {
		this.picture = picture;
	}
	
}
