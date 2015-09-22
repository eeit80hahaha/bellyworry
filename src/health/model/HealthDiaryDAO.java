package health.model;

import java.util.List;

import ranking.model.ReflectVO;

public interface HealthDiaryDAO {
	public abstract HealthDiaryVO selectByPrimaryKey(long no);
	
	public abstract List<HealthDiaryVO> selectByMemberNo(int memberNo);

	public abstract List<HealthDiaryVO> getAll();

	public abstract long insert(HealthDiaryVO vo);

	public abstract int update(HealthDiaryVO vo);

	public abstract boolean delete(long no);
	
	public abstract  List<HealthDiaryVO> dateSelect(int memberNo,java.util.Date date);
	
	public abstract List<HealthDiaryVO> getDatePage(int pageNo, int pageSize, 
			int memberNo ,int year ,int month);
	
	public abstract int getDateTotalCount(int memberNo ,int year ,int month);
	
	public abstract int repeatDiary(int memberNo, java.util.Date date);
	
}
