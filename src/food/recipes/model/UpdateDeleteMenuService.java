package food.recipes.model;

import java.util.List;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;
import calories.model.dao.FoodCalDAOHbm;
import food.combo.model.MealDetailDAO;
import food.combo.model.MealDetailVO;
import food.combo.model.dao.MealDetailDAOHbm;
import food.recipes.model.dao.CookDAOHbm;
import food.recipes.model.dao.FoodItemDAOHbm;
import food.recipes.model.dao.FoodListDAOHbm;

public class UpdateDeleteMenuService {
	private FoodItemDAO foodItemDao = new FoodItemDAOHbm();
	private FoodListDAOHbm foodListDao = new FoodListDAOHbm();
	private FoodCalDAO foodCalDao = new FoodCalDAOHbm();
	private CookDAO cookDao = new CookDAOHbm();
	private MealDetailDAO mealDetail = new MealDetailDAOHbm();
	
	public boolean deleteFoodCal(int foodCalNo) {
		boolean result = false;
		result = foodCalDao.delete(foodCalNo);
		
		return result;
	}
	
	public List<MealDetailVO> selectByFoodNo(int foodNo){
		List<MealDetailVO> result=null;
		if (foodNo!=0){
			result=mealDetail.selectByFoodNo(foodNo);
		}		
		return result;
	}
	
	public FoodCalVO selectbyId(int foodNo) {
		FoodCalVO result = null;
		if (foodNo != 0) {
			result = foodCalDao.selectByPrimaryKey(foodNo);
		}
		return result;
	}
	
	public List<FoodListVO> selectbyCookNo(int cookNo) {
		List<FoodListVO> result = null;
		if (cookNo != 0) {
			result = foodListDao.selectByCookNo(cookNo);
		}
		return result;
	}
		
	public boolean deleteFoodList(int cookNo,int useFoodNo){
		
		if (cookNo!=0 && useFoodNo!=0){
			return foodListDao.delete(cookNo,useFoodNo);
		}
		return false;
	}
	
	public boolean deleteCook(int cookNo){
		if (cookNo!=0){
			return cookDao.delete(cookNo);
		}
		return false;
	}

	public boolean deleteFoodItem(int usefoodNo){
	
	if (usefoodNo!=0){
		return foodItemDao.delete(usefoodNo);
	}
	return false;
}


}
