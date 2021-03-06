package health.model;

import java.util.List;

public interface ExerciseRecordDAO {
	public abstract ExerciseRecordVO selectByPrimaryKey(long no);
	
	public abstract List<ExerciseRecordVO> selectByMemberNo(int memberNo);

	public abstract List<ExerciseRecordVO> getAll();

	public abstract long insert(ExerciseRecordVO vo);

	public abstract int update(ExerciseRecordVO vo);

	public abstract boolean delete(long no);
	
	public abstract int exercal(int memberNo, java.util.Date date);
	
	public abstract List<ExerciseRecordVO> exerday(int memberNo, java.util.Date date);
	
}
