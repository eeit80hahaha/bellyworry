package ranking.model;

import java.io.Serializable;
import java.util.List;

public class ReflectPageVO implements Serializable  {

	int pageNo;
	int pageSize;
	int rowCount;
	int totalPages;
	List<ReflectVO> reflectpage;
	
	public ReflectPageVO(){
		
	}
	
	public ReflectPageVO(int pageNo, int pageSize, int rowCount,
			List<ReflectVO> reflectpage) {
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
		this.reflectpage = reflectpage;
	}
	
	@Override
	public String toString() {
		return "{" + pageNo + ":" + pageSize + ":" + rowCount + ":" + totalPages + ":" + reflectpage + "}";
	}

	public int getPageNo() {
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getRowCount() {
		return rowCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<ReflectVO> getReflectpage() {
		return reflectpage;
	}
	public void setReflectpage(List<ReflectVO> reflectpage) {
		this.reflectpage = reflectpage;
	}
	
}
