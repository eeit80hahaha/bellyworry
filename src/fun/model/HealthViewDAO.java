package fun.model;

import java.util.List;

public interface HealthViewDAO {
	public abstract HealthViewVO selectByPrimaryKey(int no);

	public abstract List<HealthViewVO> selectByViewClassVO(ViewClassVO vo,int pageNo ,int pageSize);
	
	public abstract List<HealthViewVO> getAll(int pageNo, int pageSize);
	
	public abstract int getDateTotalCount(ViewClassVO vo);

	public abstract int insert(HealthViewVO vo);

	public abstract int update(HealthViewVO vo);

	public abstract boolean delete(int no);
}
