package ranking.model;

import java.io.Serializable;

import register.model.MemberVO;

public class HeroVO implements Serializable{

	private int memberNo;
	MemberVO membervo;
	private double weightDiff;
	private int num;
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof HeroVO)) {
			HeroVO temp = (HeroVO) obj;
			if(this.memberNo == temp.memberNo) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "{"+memberNo+":"+membervo+":"+weightDiff+":"+num+"}";
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public MemberVO getMembervo() {
		return membervo;
	}
	public void setMembervo(MemberVO membervo) {
		this.membervo = membervo;
	}
	public double getWeightDiff() {
		return weightDiff;
	}
	public void setWeightDiff(double weightDiff) {
		this.weightDiff = weightDiff;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
