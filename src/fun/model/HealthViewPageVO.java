package fun.model;

import java.io.Serializable;
import java.util.List;

import health.model.HealthDiaryVO;

public class HealthViewPageVO implements Serializable{
	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<HealthViewVO> healthViewPage;
	
	public HealthViewPageVO(){
		
	}
	
	public HealthViewPageVO(int pageNo, int pageSize, int rowCount,
			List<HealthViewVO> healthViewPage) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.totalPages = (int) Math.ceil((double)rowCount/pageSize);
		this.healthViewPage = healthViewPage;
	}
	
	@Override
	public String toString() {
		return "{"+pageNo+":"+pageSize+":"+rowCount+":"+totalPages+":"+healthViewPage+"}";
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

	public List<HealthViewVO> getHealthViewPage() {
		return healthViewPage;
	}

	public void setHealthViewPage(List<HealthViewVO> healthViewPage) {
		this.healthViewPage = healthViewPage;
	}
	
	
	
	
	
}
