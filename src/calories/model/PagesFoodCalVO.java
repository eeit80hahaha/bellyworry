package calories.model;

import java.io.Serializable;
import java.util.List;

//為了換頁所新增的PagesFoodCalVO 
public class PagesFoodCalVO implements Serializable  {

	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<FoodCalVO> herohealdiarypage;
	
	public PagesFoodCalVO(int pageNo, int pageSize, int rowCount,
			List<FoodCalVO> herohealdiarypage) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.totalPages = ( rowCount / pageSize ) + 1;
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

	public List<FoodCalVO> getHerohealdiarypage() {
		return herohealdiarypage;
	}
	public void setHerohealdiarypage(List<FoodCalVO> herohealdiarypage) {
		this.herohealdiarypage = herohealdiarypage;
	}
	
}
