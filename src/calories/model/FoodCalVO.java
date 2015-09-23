package calories.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import food.combo.model.MealNameVO;
import food.recipes.model.CookVO;

public class FoodCalVO implements Serializable{
	private int foodNo;
	private String name;
	private int menuNo;
	private int cal;
	private String count;
	private int weight;
	private Integer cookNo;
	private byte[] picture;
	//16~23行轉圖專用，所創的
	private String picture1;
	private Set<MealNameVO> mealnames = new HashSet<MealNameVO>();
	private CookVO cooks;
	private MenuVO menus;
	
	public MenuVO getMenus() {
		return menus;
	}
	public void setMenus(MenuVO menus) {
		this.menus = menus;
	}
	public Set<MealNameVO> getMealnames() {
		return mealnames;
	}
	public void setMealnames(Set<MealNameVO> mealnames) {
		this.mealnames = mealnames;
	}
	public CookVO getCooks() {
		return cooks;
	}
	public void setCooks(CookVO cooks) {
		this.cooks = cooks;
	}
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
	public Integer getCookNo() {
		return cookNo;
	}
	public void setCookNo(Integer cookNo) {
		this.cookNo = cookNo;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}
