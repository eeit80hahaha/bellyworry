package health.model;

import java.util.List;

import health.model.dao.EatRecordDAOHbm;

public class EatRecordService {
	private EatRecordDAO eatrDAO = new EatRecordDAOHbm();
	
	public int insertList(List<EatRecordVO> eatrlist){
		int result = 0;
		for(EatRecordVO eatrvo : eatrlist){
			eatrDAO.insert(eatrvo);
		}
		return result;
	}
	
	public List<EatRecordVO> getEatrmdt (int memberNo,java.util.Date healthDate, String eattime){
		return eatrDAO.getEatrmdt(memberNo , healthDate , eattime);
	}
}
