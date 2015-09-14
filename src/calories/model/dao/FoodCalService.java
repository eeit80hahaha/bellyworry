package calories.model.dao;

import java.util.ArrayList;
import java.util.List;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;

public class FoodCalService {
	private FoodCalDAO foodDao = new FoodCalDAOHbm();
	
	public List<FoodCalVO>select(FoodCalVO vo) {
		List<FoodCalVO> result = null;
		if(vo!=null && vo.getCookNo()!=0) {
			FoodCalVO temp = foodDao.selectByPrimaryKey(vo.getFoodNo());
			if(temp!=null) {
				result = new ArrayList<FoodCalVO>();
				result.add(temp);	
			}
		} else {
			result = foodDao.getAll(); 
		}
		return result;
	}
	public int insert(FoodCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = foodDao.insert(vo);
		}
		return result;
	}
	
	public int update(FoodCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = foodDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(FoodCalVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = foodDao.delete(vo.getFoodNo());
		}
		return result;
	}
	
	public static void main(String[] args) {
		FoodCalService service = new FoodCalService();
		List<FoodCalVO> list = service.select(null);
		System.out.println("beans="+list);
	}
}
