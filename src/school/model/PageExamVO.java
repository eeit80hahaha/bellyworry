package school.model;

import java.io.Serializable;
import java.util.List;



//為了換頁所新增的PagesFoodCalVO 
public class PageExamVO implements Serializable  {

	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<ExamVO> exampage;
	public  PageExamVO() {
		
	}
	
	public PageExamVO(int pageNo, int pageSize, int rowCount,
			List<ExamVO> exampage) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.totalPages = (int)Math.ceil(((double)rowCount / pageSize ));
		System.out.println("========================");
		System.out.println("test1:"+ (double)rowCount / pageSize);
		System.out.println("test2:"+(int)Math.ceil((double) rowCount / pageSize ));
		this.exampage = exampage;
	}
	
	@Override
	public String toString() {
		return "{" + pageNo + ":" + pageSize + ":" + rowCount + ":" + totalPages + ":" + exampage + "}";
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

	public List<ExamVO> getExampage() {
		return exampage;
	}

	public void setExampage(List<ExamVO> exampage) {
		this.exampage = exampage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	
}
