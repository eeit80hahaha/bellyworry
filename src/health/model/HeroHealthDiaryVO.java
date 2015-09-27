package health.model;

import java.io.Serializable;
import java.util.List;

public class HeroHealthDiaryVO implements Serializable  {

	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<HealthDiaryVO> herohealdiarypage;
	
	public HeroHealthDiaryVO(){
		
	}
	
	public HeroHealthDiaryVO(int pageNo, int pageSize, int rowCount,
			List<HealthDiaryVO> herohealdiarypage) {
		this.pageNo = pageNo;
		
		if(pageSize <= 0){
			this.pageSize = 1;
		}else{
			this.pageSize = pageSize;
		}
		
		this.rowCount = rowCount;
		
		if(rowCount <= 0){
			this.totalPages = 1;
		}else{
			this.totalPages = (int) Math.ceil( (double) rowCount / pageSize );
		}
		this.herohealdiarypage = herohealdiarypage;
	}
	
	@Override
	public String toString() {
		return "{" + pageNo + ":" + pageSize + ":" + rowCount + ":" + totalPages + ":" + herohealdiarypage + "}";
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<HealthDiaryVO> getHerohealdiarypage() {
		return herohealdiarypage;
	}
	public void setHerohealdiarypage(List<HealthDiaryVO> herohealdiarypage) {
		this.herohealdiarypage = herohealdiarypage;
	}
	
}
