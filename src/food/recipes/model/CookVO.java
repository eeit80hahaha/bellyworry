package food.recipes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CookVO implements Serializable{
	private int cookNo;
	private String wayNo;
	private byte[] picture;	
	private Set<FoodItemVO> fooditems = new HashSet<FoodItemVO>();
	public Set<FoodItemVO> getFooditems() {
		return fooditems;
	}

	public void setFooditems(Set<FoodItemVO> fooditems) {
		this.fooditems = fooditems;
	}

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
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}



	
}
