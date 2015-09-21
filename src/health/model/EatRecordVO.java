package health.model;

import java.io.Serializable;

import calories.model.FoodCalVO;
import register.model.MemberVO;

public class EatRecordVO implements Serializable {
	// //*****************many-to-one use*********************
	 private long no;
//	 private MemberVO memberVO;
	 private java.sql.Date date;
	 private String time;
	 private FoodCalVO foodCalVO;
	 private int count;
	
	 @Override
	 public String toString() {
	 return
	 "{"+no+":"+memberNo/*memberVO.getMemberNo()*/+":"+date+":"+time+":"+foodCalVO+":"+count+"}";
	 }
//	 public MemberVO getMemberVO() {
//	 return memberVO;
//	 }
//	 public void setMemberVO(MemberVO memberVO) {
//	 this.memberVO = memberVO;
//	 }
	 public FoodCalVO getFoodCalVO() {
	 return foodCalVO;
	 }
	 public void setFoodCalVO(FoodCalVO foodCalVO) {
	 this.foodCalVO = foodCalVO;
	 }
	// //*********************************************************

	// ************** without many-to-one*********************
//	private long no;
	private int memberNo;
//	private java.util.Date date;
//	private String time;
//	private int foodNo;
//	private int count;
//
//	@Override
//	public String toString() {
//		return "{" + no + ":" + memberNo + ":" + date + ":" + time + ":"
//				+ foodNo + ":" + count + "}";
//	}
//
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

//	public int getFoodNo() {
//		return foodNo;
//	}
//
//	public void setFoodNo(int foodNo) {
//		this.foodNo = foodNo;
//	}

	// *********************************************************
	@Override
	public boolean equals(Object obj) {
		if (obj != null && (obj instanceof EatRecordVO)) {
			EatRecordVO temp = (EatRecordVO) obj;
			if (this.no == temp.no) {
				return true;
			}
		}
		return false;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
