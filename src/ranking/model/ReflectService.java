package ranking.model;

import health.model.HealthDiaryDAO;
import health.model.dao.HealthDiaryDaoHbm;
import ranking.model.dao.ReflectDAOHbm;

public class ReflectService {
	
	private ReflectDAO reflectdao = new ReflectDAOHbm();
	private HealthDiaryDAO healthdiarydao = new HealthDiaryDaoHbm();
	
	public int insert(ReflectVO vo){
		
		int repeatD = healthdiarydao.repeatDiary(vo.getReflectedNo(),
				vo.getReflectedDate());
		if(repeatD==1000){
			int repeatR = reflectdao.repeatReflect(vo);
			if(repeatR == 1000){
				int ins = reflectdao.insert(vo);
				if(ins == -300){
					//-300  SQL error
					return ins;
				}else{
					//insert success return ReflectVO.getNo()
					return ins;
				}
				
			}else if(repeatR == -100){
				//-100  unique
				return repeatR;
			}else {
				//-300  SQL error
				return repeatR;
			}
		}else if(repeatD == -400){
			//-400  Not available
			return repeatD;
		}else {
			//-300  SQL error
			return repeatD;
		}
	}
	
	public ReflectVO selectByPrimaryKey(int no){
		ReflectVO result = null;
		
		result = reflectdao.selectByPrimaryKey(no);
		
		return result;
	}
	
}
