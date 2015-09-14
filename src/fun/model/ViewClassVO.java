package fun.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ViewClassVO implements Serializable{
	private int viewClassNo;
	private String name;
	
////one-to-many HealthView========
//	private Set<HealthViewVO> healthViews = new HashSet<HealthViewVO>();	
//	public Set<HealthViewVO> getHealthViews() {
//		return healthViews;
//	}
//	public void setHealthViews(Set<HealthViewVO> healthViews) {
//		this.healthViews = healthViews;
//	}
////==============================
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof ViewClassVO)) {
			ViewClassVO temp = (ViewClassVO) obj;
			if(this.viewClassNo == temp.viewClassNo) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "{"+viewClassNo+":"+name+"}";
	}
	
//	@Override
//	public String toString() {
//		return "{"+viewClassNo+":"+name+":"+healthViews+"}";
//	}
	
	
	
	public int getViewClassNo() {
		return viewClassNo;
	}
	public void setViewClassNo(int viewClassNo) {
		this.viewClassNo = viewClassNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
