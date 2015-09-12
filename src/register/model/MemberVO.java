package register.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import health.model.EatRecordVO;
import health.model.ExerciseRecordVO;
import health.model.HealthDiaryVO;
import ranking.model.ReflectVO;

public class MemberVO implements Serializable{
	private int memberNo;
	private String id;
	private String password;
	private String firstName;
	private String lastName;
	private String nickname;
	private String email;
	private java.util.Date birthday;
	private String gender;
	private int purview;
	
//// one-to-many healthDiary
//	private Set<HealthDiaryVO> diarys = new HashSet<HealthDiaryVO>();
//	public Set<HealthDiaryVO> getDiarys() {
//		return diarys;
//	}
//	
//	public void setDiarys(Set<HealthDiaryVO> diarys) {
//		this.diarys = diarys;
//	}
//	
//// one-to-many eatRecord
//	private Set<EatRecordVO> eatRecords = new HashSet<EatRecordVO>();
//	public Set<EatRecordVO> getEatRecords() {
//		return eatRecords;
//	}
//	public void setEatRecords(Set<EatRecordVO> eatRecords) {
//		this.eatRecords = eatRecords;
//	}
//	
//// one-to-many exerciseRecord
//	private Set<ExerciseRecordVO> exerciseRecords = new HashSet<ExerciseRecordVO>();
//	public Set<ExerciseRecordVO> getExerciseRecords() {
//		return exerciseRecords;
//	}
//	public void setExerciseRecords(Set<ExerciseRecordVO> exerciseRecords) {
//		this.exerciseRecords = exerciseRecords;
//	}
//	
//// one-to-many reflectNo
//	private Set<ReflectVO> reflects = new HashSet<ReflectVO>();
//	public Set<ReflectVO> getReflects() {
//		return reflects;
//	}
//	public void setReflects(Set<ReflectVO> reflects) {
//		this.reflects = reflects;
//	}
//	
//// one-to-many authorNo 
//	private Set<ReflectVO> authors = new HashSet<ReflectVO>();
//	public Set<ReflectVO> getAuthors() {
//		return authors;
//	}
//	public void setAuthors(Set<ReflectVO> authors) {
//		this.authors = authors;
//	}
	
	@Override
	public String toString() {
		return "{"+memberNo+":"+id+":"+password+":"+firstName+":"+lastName+
				":"+nickname+":"+email+":"+birthday+":"+gender+":"+purview+"}";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof MemberVO)) {
			MemberVO temp = (MemberVO) obj;
			if(this.memberNo == temp.memberNo) {
				return true;
			}
		}
		return false;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPurview() {
		return purview;
	}
	public void setPurview(int purview) {
		this.purview = purview;
	}
}
