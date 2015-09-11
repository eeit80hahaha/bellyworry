package fun.model;

import java.util.List;

import register.model.MemberVO;

public interface ViewClassDAO {
	public abstract ViewClassVO selectByPrimaryKey(int viewClassNo);

	public abstract List<ViewClassVO> getAll();

	public abstract int insert(ViewClassVO vo);

	public abstract int update(ViewClassVO vo);

	public abstract boolean delete(int viewClassNo);
	
	public abstract ViewClassVO selectByName(String name);
}
