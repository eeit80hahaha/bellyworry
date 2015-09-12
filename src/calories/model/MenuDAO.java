package calories.model;

import java.util.List;

public interface MenuDAO {
	public abstract MenuVO selectByPrimaryKey(int menuNo);

	public abstract List<MenuVO> getAll();

	public abstract int insert(MenuVO vo);

	public abstract int update(MenuVO vo);

	public abstract boolean delete(int menuNo);
}
