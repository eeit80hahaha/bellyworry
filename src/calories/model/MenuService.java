package calories.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.codec.binary.Base64;

import calories.model.dao.FoodCalDAOHbm;
import calories.model.dao.MenuDaoHbm;
import food.combo.model.DayMealDAO;
import food.combo.model.DayMealVO;
import food.combo.model.MealNameDAO;
import food.combo.model.MealNameVO;
import food.combo.model.dao.DayMealDAOHbm;
import food.combo.model.dao.MealNameDAOHbm;

public class MenuService {
	private FoodCalDAO foodCalDao = new FoodCalDAOHbm();
	private MealNameDAO mealNameDao = new MealNameDAOHbm();
	private MenuDAO menuDao = new MenuDaoHbm();
	private DayMealDAO dayMealDao = new DayMealDAOHbm();

	public List<DayMealVO> selectDayMeal(DayMealVO vo) {
		List<DayMealVO> result = null;
		if (vo != null && vo.getNo() != 0) {
			System.out.println("=========1==============");
			DayMealVO temp = dayMealDao.selectByPrimaryKey(vo.getNo());
			if (temp != null) {
				result = new ArrayList<DayMealVO>();
				result.add(temp);
			}
		} else {
			System.out.println("=========2==============");
			result = dayMealDao.getAll();
			System.out.println("=========3=============="+result);
		}
		return result;
	}

	public List<MenuVO> selectMenu(MenuVO vo) {
		List<MenuVO> result = null;
		if (vo != null && vo.getMenuNo() != 0) {
			MenuVO temp = menuDao.selectByPrimaryKey(vo.getMenuNo());
			if (temp != null) {
				result = new ArrayList<MenuVO>();
				result.add(temp);
			}
		} else {
			result = menuDao.getAll();
		}
		return result;
	}

	public Collection<FoodCalVO> base(Collection<FoodCalVO> vo) {
		Collection<FoodCalVO> bean = null;
		if (vo instanceof Set) {
			bean = new HashSet<FoodCalVO>();
		} else if (vo instanceof List) {
			bean = new ArrayList<FoodCalVO>();
		}

		for (FoodCalVO element : vo) {
			FoodCalVO element1 = new FoodCalVO();
			element1.setFoodNo(element.getFoodNo());
			element1.setName(element.getName());
			element1.setMenuNo(element.getMenuNo());
			element1.setCal(element.getCal());
			element1.setCount(element.getCount());
			element1.setWeight(element.getWeight());
			element1.setCookNo(element.getCookNo());
			element1.setCooks(element.getCooks());
			element1.setMenus(element.getMenus());
			element1.setMealnames(element.getMealnames());
			element1.setPicture1(Base64.encodeBase64String(element.getPicture()));
			bean.add(element1);
		}
		return bean;
	}

	public List<FoodCalVO> select(FoodCalVO vo) {
		List<FoodCalVO> result = null;
		if (vo != null && vo.getFoodNo() != 0) {
			FoodCalVO temp = foodCalDao.selectByPrimaryKey(vo.getFoodNo());
			if (temp != null) {
				result = new ArrayList<FoodCalVO>();
				result.add(temp);
			}
		} else {
			result = foodCalDao.getAll();
		}
		return result;
	}

	public int insert(FoodCalVO vo) {
		int result = 0;
		if (vo != null) {
			result = foodCalDao.insert(vo);
		}
		return result;
	}

	public FoodCalVO selectbyId(int vo) {
		FoodCalVO result = null;
		if (vo != 0) {
			result = foodCalDao.selectByPrimaryKey(vo);
		}
		return result;
	}

	public List<FoodCalVO> selectbyMenuNo(int vo) {
		List<FoodCalVO> result = null;
		if (vo != 0) {
			result = foodCalDao.selectByMenuNo(vo);
		}
		return result;
	}

	public int update(FoodCalVO vo) {
		int result = 0;
		if (vo != null) {
			result = foodCalDao.update(vo);
		}
		return result;
	}

	public boolean delete(FoodCalVO vo) {
		boolean result = false;
		if (vo != null) {
			result = foodCalDao.delete(vo.getCookNo());
		}
		return result;
	}

	public List<MealNameVO> selectMealName(MealNameVO vo) {
		List<MealNameVO> result = null;
		if (vo != null && vo.getMealNo() != 0) {
			MealNameVO temp = mealNameDao.selectByPrimaryKey(vo.getMealNo());
			if (temp != null) {
				result = new ArrayList<MealNameVO>();
				result.add(temp);
			}
		} else {
			result = mealNameDao.getAll();
		}
		return result;
	}

	public static void main(String[] args) {
		MenuService service = new MenuService();
		List<FoodCalVO> list = service.select(null);
		System.out.println("beans=" + list);
	}

}
