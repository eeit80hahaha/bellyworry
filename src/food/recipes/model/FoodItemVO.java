package food.recipes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FoodItemVO implements Serializable{
	private int useFoodNo;
	private String name;
	private String type;
	private String count;
	private Set<CookVO> cooks = new HashSet<CookVO>();
	
	public Set<CookVO> getCooks() {
		return cooks;
	}
	public void setCooks(Set<CookVO> cooks) {
		this.cooks = cooks;
	}
	public FoodItemVO(){
		
	}
	public String toString(){
		return "("+name+":"+type+":"+count+")";
	}
	public boolean equals(Object obj){
		if(obj!=null && (obj instanceof FoodItemVO)){
			FoodItemVO temp1 = (FoodItemVO) obj;
			if(this.useFoodNo == temp1.useFoodNo){
				return true;
			}
		}
		return false;
	}
	
	public int getUseFoodNo() {
		return useFoodNo;
	}
	public void setUseFoodNo(int useFoodNo) {
		this.useFoodNo = useFoodNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
