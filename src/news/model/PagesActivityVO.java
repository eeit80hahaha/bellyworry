package news.model;

import java.io.Serializable;
import java.util.List;

//為了換頁所新增的PagesFoodCalVO 
public class PagesActivityVO implements Serializable  {

	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<ActivityVO> activitypage;
	
	public PagesActivityVO(int pageNo, int pageSize, int rowCount,
			List<ActivityVO> activitypage) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.totalPages = (int)Math.ceil(((double)rowCount / pageSize ));
		this.activitypage = activitypage;
	}
	
	public List<ActivityVO> getActivitypage() {
		return activitypage;
	}

	public void setActivitypage(List<ActivityVO> activitypage) {
		this.activitypage = activitypage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "{" + pageNo + ":" + pageSize + ":" + rowCount + ":" + totalPages + ":" + activitypage + "}";
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


	
}
