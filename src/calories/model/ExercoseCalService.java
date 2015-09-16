package calories.model;

import java.util.ArrayList;
import java.util.List;

import calories.model.dao.ExerciseCalDaoHbm;

public class ExercoseCalService {
	private ExerciseCalDAO exercisecalDao = new ExerciseCalDaoHbm();
	
	public List<ExerciseCalVO>select(ExerciseCalVO vo) {
		List<ExerciseCalVO> result = null;
		if(vo!=null && vo.getExerciseNo()!=0) {
			ExerciseCalVO temp = exercisecalDao.selectByPrimaryKey(vo.getExerciseNo());
			if(temp!=null) {
				result = new ArrayList<ExerciseCalVO>();
				result.add(temp);	
			}
		} else {
			result = exercisecalDao.getAll(); 
		}
		return result;
	}
	public int insert(ExerciseCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = exercisecalDao.insert(vo);
		}
		return result;
	}
	
	public int update(ExerciseCalVO vo) {
		int result = 0;
		if(vo!=null) {
			result = exercisecalDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(ExerciseCalVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = exercisecalDao.delete(vo.getExerciseNo());
		}
		return result;
	}
	
	public static void main(String[] args) {
		ExercoseCalService service = new ExercoseCalService();
		List<ExerciseCalVO> list = service.select(null);
		System.out.println("beans="+list);
	}
}
