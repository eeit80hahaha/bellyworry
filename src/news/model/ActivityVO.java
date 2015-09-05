package news.model;

import java.io.Serializable;
import java.sql.Blob;

public class ActivityVO implements Serializable {
	private int no;
	private String name;
	private String content;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private String address;
	private Blob picture;
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof ActivityVO)) {
			ActivityVO temp = (ActivityVO) obj;
			if(this.no == temp.no) {
				return true;
			}			
		}
		return false;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getStartTime() {
		return startTime;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "{"+no+":"+name+":"+content+":"+startTime+":"+endTime+":"+address+":"+picture+"}";
	}
	
	

}
