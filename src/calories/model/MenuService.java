package calories.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import calories.model.dao.FoodCalDAOHbm;
import food.recipes.model.CookVO;
import food.recipes.model.dao.CookService;

public class MenuService {
private FoodCalDAO foodCalDao = new FoodCalDAOHbm();
	
	public List<FoodCalVO> base(List<FoodCalVO> vo){
		List<FoodCalVO> bean = new ArrayList<FoodCalVO>();		
		 for(FoodCalVO element : vo) {
			 FoodCalVO element1=new FoodCalVO();
			 element1.setFoodNo(element.getFoodNo());
			 element1.setName(element.getName());
			 element1.setMenuNo(element.getMenuNo());
			 element1.setCal(element.getCal());
			 element1.setCount(element.getCount());
			 element1.setWeight(element.getWeight());
			 element1.setCookNo(element.getCookNo());
			 element1.setPicture1(Base64.encodeBase64String(element.getPicture()));
		     bean.add(element1);
		 }
		return bean;
	}
	public List<FoodCalVO>select(FoodCalVO vo) {
		List<FoodCalVO> result = null;
		if(vo!=null && vo.getFoodNo()!=0) {
			FoodCalVO temp = foodCalDao.selectByPrimaryKey(vo.getFoodNo());
			if(temp!=null) {
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
		if(vo!=null) {
			result = foodCalDao.insert(vo);
		}
		return result;
	}
	public FoodCalVO selectbyId(int vo) {
		FoodCalVO result = null;
		if(vo!=0) {
			result = foodCalDao.selectByPrimaryKey(vo);
		}
		return result;
	}
	
	public int update(FoodCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = foodCalDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(FoodCalVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = foodCalDao.delete(vo.getCookNo());
		}
		return result;
	}
	
	public static void main(String[] args) {
		MenuService service = new MenuService();
		List<FoodCalVO> list = service.select(null);
		System.out.println("beans="+list);
	}
	

}
