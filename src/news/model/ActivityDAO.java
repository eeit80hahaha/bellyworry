package news.model;

import java.util.List;

public interface ActivityDAO {
	public abstract ActivityVO selectByPrimaryKey(int no);

	public abstract List<ActivityVO> getAll();

	public abstract int insert(ActivityVO vo);

	public abstract int update(ActivityVO vo);

	public abstract boolean delete(int no);
	
	public abstract List<ActivityVO> findBySname(String name);
	
	public abstract List<String> sawaddress();
	
	public abstract List<java.sql.Timestamp> sawendtime();

	public abstract String getDateTime();
	
	//換頁所需要的getDatePage
//	public abstract List<ActivityVO> getDatePage(int pageNo, int pageSize);
//	
//	public abstract int getDateTotalCount();
	
	
	
	
	
	
}
