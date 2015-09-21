package calories.model;

import health.model.HealthDiaryVO;

import java.io.InputStream;
import java.util.List;

public interface FoodCalDAO {
	public abstract FoodCalVO selectByPrimaryKey(int foodNo);

	public abstract List<FoodCalVO> getAll();

	public abstract int insert(FoodCalVO vo);

	public abstract int update(FoodCalVO vo);

	public abstract boolean delete(int foodNo);

	
	//換頁所需要的getDatePage
	public abstract List<FoodCalVO> getDatePage(int pageNo, int pageSize);
	
	public abstract int getDateTotalCount();
	
	
}
