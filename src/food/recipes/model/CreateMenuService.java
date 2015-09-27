package food.recipes.model;

import java.util.List;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;
import calories.model.MenuDAO;
import calories.model.MenuVO;
import calories.model.dao.FoodCalDAOHbm;
import calories.model.dao.MenuDaoHbm;
import food.recipes.model.dao.CookDAOHbm;
import food.recipes.model.dao.FoodItemDAOHbm;
import food.recipes.model.dao.FoodListDAOHbm;

public class CreateMenuService {
	private CookDAO cookDao = new CookDAOHbm();
	private FoodItemDAO foodItemDao = new FoodItemDAOHbm();
	private FoodListDAO foodListDao = new FoodListDAOHbm();
	private FoodCalDAO foodCalDao = new FoodCalDAOHbm();
		
	public int insertCook(CookVO vo) {
		int result = 0;
		if(vo!=null) {
			result = cookDao.insert(vo);
		}
		return result;
	}
	
	public CookVO cookKey(int no){
		CookVO bean=null;
		bean=cookDao.selectByPrimaryKey(no);
		return bean;
	}
	
	public FoodItemVO insertFoodItem(FoodItemVO vo) {
		FoodItemVO result = null;
		if(vo!=null) {
			result = foodItemDao.insert(vo);
		}
		return result;
	}
		
	public FoodListVO insertFoodList(FoodListVO vo) {
		FoodListVO result = null;
		if(vo!=null) {
			result = foodListDao.insert(vo);
		}
		return result;
	}
	
	public int insertFoodCal(FoodCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = foodCalDao.insert(vo);
		}
		return result;
	}
	
	public FoodCalVO foodCalVOKey(int no){
		FoodCalVO bean=null;
		bean=foodCalDao.selectByPrimaryKey(no);
		return bean;
	}
	

}
