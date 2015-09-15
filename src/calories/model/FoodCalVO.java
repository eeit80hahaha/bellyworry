package calories.model;

import java.io.Serializable;
import java.sql.Blob;

public class FoodCalVO implements Serializable{
	private int foodNo;
	private String name;
	private int menuNo;
	private int cal;
	private String count;
	private int weight;
	private int cookNo;
	private byte[] picture;
	//16~23行轉圖專用，所創的
	private String picture1;
	
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	@Override
	public String toString() {
		return "{"+foodNo+":"+name+":"+menuNo+":"+cal+":"+count+":"+weight+":"+cookNo+":"+picture+"}";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof FoodCalVO)) {
			FoodCalVO temp = (FoodCalVO) obj;
			if(this.foodNo == temp.foodNo) {
				return true;
			}
		}
		return false;
	}

	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCookNo() {
		return cookNo;
	}
	public void setCookNo(int cookNo) {
		this.cookNo = cookNo;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}
