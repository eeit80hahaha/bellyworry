package food.recipes.model;

import java.util.List;

public interface CookDAO {
	public abstract CookVO selectByPrimaryKey(int cookNo);

	public abstract List<CookVO> getAll();

	public abstract int insert(CookVO vo);

	public abstract int update(CookVO vo);

	public abstract boolean delete(int cookNo);
}
