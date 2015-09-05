package food.recipes.model;

import java.util.List;

public interface FoodItemDAO {
	public abstract FoodItemVO selectByPrimaryKey(int useFoodNo);

	public abstract List<FoodItemVO> getAll();

	public abstract FoodItemVO insert(FoodItemVO vo);

	public abstract FoodItemVO update(FoodItemVO vo);

	public abstract boolean delete(int useFoodNo);
}
