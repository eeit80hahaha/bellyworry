package news.model;

import java.io.File;
import java.io.FileInputStream;

import java.io.Serializable;
import java.sql.Blob;

public class ActivityVO implements Serializable {
	private int no;
	private String name;
	private String content;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private String endTime1;
	private String address;
	private byte[] picture;
    private String picture1;
    private String url;
    private String boss;
    

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getEndTime1() {
		return endTime1;
	}
	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}

	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
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


	@Override
	public String toString() {
		return "{"+no+":"+name+":"+content+":"+startTime+":"+endTime+":"+address+":"+picture+":"+url+":"+boss+"}";
	}
	
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
	
	

}
