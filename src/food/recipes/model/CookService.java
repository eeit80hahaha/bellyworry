package food.recipes.model;

import java.util.ArrayList;
import java.util.List;

import food.recipes.model.dao.CookDAOHbm;

public class CookService {
	private CookDAO cookDao = new CookDAOHbm();
	
	public List<CookVO>select(CookVO vo) {
		List<CookVO> result = null;
		if(vo!=null && vo.getCookNo()!=0) {
			CookVO temp = cookDao.selectByPrimaryKey(vo.getCookNo());
			if(temp!=null) {
				result = new ArrayList<CookVO>();
				result.add(temp);	
			}
		} else {
			result = cookDao.getAll(); 
		}
		return result;
	}
	public int insert(CookVO vo) {
		int result = 0;
		if(vo!=null) {
			result = cookDao.insert(vo);
		}
		return result;
	}
	
	public int update(CookVO vo) {
		int result = 0;
		if(vo!=null) {
			result = cookDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(CookVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = cookDao.delete(vo.getCookNo());
		}
		return result;
	}
	
}
