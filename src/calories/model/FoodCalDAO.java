package calories.model;

import java.io.InputStream;
import java.util.List;

public interface FoodCalDAO {
	public abstract FoodCalVO selectByPrimaryKey(int foodNo);

	public abstract List<FoodCalVO> getAll();

	public abstract int insert(FoodCalVO vo);

	public abstract int update(FoodCalVO vo);

	public abstract boolean delete(int foodNo);
}
