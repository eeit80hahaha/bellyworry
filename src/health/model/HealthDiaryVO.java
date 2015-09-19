package health.model;

import java.io.Serializable;
import java.util.List;

public class HealthDiaryVO implements Serializable {
	private long no;
	private int memberNo;
	private java.sql.Date date;
	private float height;
	private float weight;
	private float waistline;
	private String title;
	private String content;
	private String share;
	private List<EatRecordVO> eatVo;
	private List<ExerciseRecordVO> exerVo;

	@Override
	public boolean equals(Object obj) {
		if (obj != null && (obj instanceof HealthDiaryVO)) {
			HealthDiaryVO temp = (HealthDiaryVO) obj;
			if (this.no == temp.no) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "{" + no + ":" + memberNo + ":" + date + ":" + height + ":"
				+ weight + ":" + waistline + ":" + title + ":" + content + ":"
				+ share + ":" + eatVo + ":" + exerVo + "}";
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getWaistline() {
		return waistline;
	}

	public void setWaistline(float waistline) {
		this.waistline = waistline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public List<EatRecordVO> getEatVo() {
		return eatVo;
	}

	public void setEatVo(List<EatRecordVO> eatVo) {
		this.eatVo = eatVo;
	}

	public List<ExerciseRecordVO> getExerVo() {
		return exerVo;
	}

	public void setExerVo(List<ExerciseRecordVO> exerVo) {
		this.exerVo = exerVo;
	}



}
