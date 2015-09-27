package init;

import java.util.ArrayList;
import java.util.List;

public class ListPage<E> {
	
	int lastPage = 0;
	int rowsCount = 0;
	int pageSize = 10;
	int pageNo = 1;
	
	List<E> list = null;
	
	public ListPage() {
		
	}
	
	public ListPage(List<E> list, int pageSize) {
		this.setList(list);
		this.setPageSize(pageSize);
		
		this.rowsCount = list.size();
		if((this.rowsCount % this.pageSize) != 0){
			this.lastPage = (this.rowsCount/this.pageSize) + 1;
		}
		else{
			this.lastPage = (this.rowsCount/this.pageSize);
		}
		//System.out.println("頁數"+(this.rowsCount));
	}
	
	public List<E> getPageList(int pageNo){
		
		if(pageNo < 1){
			pageNo = 1;
		}
		if(pageNo > this.lastPage){
			pageNo = this.lastPage;
		}
		
		this.setPageNo(pageNo);
		
		List<E> pageList = new ArrayList<E>();
		
		int startIndex = (pageNo - 1) * this.pageSize;
		
		System.out.println("startIndex=" + startIndex);
		
		int finalSize = this.pageSize;
		if(pageNo == this.lastPage && (this.rowsCount % this.pageSize) != 0){
			finalSize = this.rowsCount % this.pageSize;
		}
		System.out.println("finalSize = " + finalSize);
		System.out.println("pageNo = " + pageNo);
		System.out.println("this.lastPage = " + this.lastPage);
		
		for(int i=0; i<finalSize; i++){
			pageList.add(i, this.list.get(i+startIndex));
		}
        
        return pageList;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}
	
	
	
}
